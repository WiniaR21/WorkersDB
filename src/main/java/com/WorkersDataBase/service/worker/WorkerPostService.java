package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.worker.Gender;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.contract.ContractDeleteService;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;


@Service
@RequiredArgsConstructor
public class WorkerPostService {
    private final WorkerRepository workerRepository;
    private final WorkerValidTool workerValidTool;
    private final ContractDeleteService contractDeleteService;

    /*        STATUS CODE
     *    1 - editing success
     *    0 - adding success
     *   -1 - error, worker is null
     *   -2 - error, worker has empty data fields
     *   -3 - error, worker data fields has special symbols
     *   -4 - error, personalNumber has invalid length
     *   -5 - error, personalNumber should be unique
     *   -6 - error, email should be unique
     *   -7 - error, firstName to short
     *   -8 - error, lastName to short
     *   -9 - error, control number in personalNumber failed */
    @Transactional
    public int addWorker(Worker worker, boolean editingWorker){

        if( worker == null ) return -1;
        if( workerValidTool.workerHasEmptyFields(worker)) return -2;
        if(!workerValidTool.noSpecialSymbols(worker)) return -3;
        if(!workerValidTool.personalNumberLengthIsFine(worker)) return -4;
        if(!workerValidTool.firstNameLengthIsFine(worker)) return -7;
        if(!workerValidTool.lastNameLengthIsFine(worker)) return -8;
        if(!workerValidTool.personalNumberIsPossible(worker)) return -9;

        if(editingWorker) {
            saveWorker(worker);
            return 1;
        }

        if (!workerValidTool.personalNumberIsUnique(worker)) return -5;
        if (!workerValidTool.emailIsUnique(worker)) return -6;

        saveWorker(worker);
        return 0;
    }

    private void saveWorker(Worker worker){
        worker.setBirthDate(readBirthDateFromPersonalNumber(worker));
        worker.setGender(readGenderFromPersonalNumber(worker));
        worker.setAge(getWorkersAgeFromBirthData(worker.getBirthDate()));
        workerRepository.save(worker);
    }
    @Transactional
    public int fireWorker(Long idWorkerToFire){
        /*
         *       ERROR CODE
         *    0 - removing success
         *   -1 - error, worker do not exist in DB
         */
        if(!workerRepository.existsById(idWorkerToFire)) return -1;

        workerRepository.findById(idWorkerToFire).ifPresent(
                worker -> {
                        if (worker.getContract() != null){
                            contractDeleteService.removeOldContract(worker);
                            workerRepository.deleteById(idWorkerToFire);
                        }
                        else {
                            workerRepository.deleteById(idWorkerToFire);
                        }
                }
        );
        return 0;
    }
    private LocalDate readBirthDateFromPersonalNumber(Worker worker){
        String personalNumber = worker.getPesel();

        String year = personalNumber.substring(0, 2);
        String month = personalNumber.substring(2, 4);
        String day = personalNumber.substring(4, 6);

        char[] monthCharArray = month.toCharArray();

        int firstDigitInMonth = Character.getNumericValue(monthCharArray[0]);
        int lastDigitInMonth = Character.getNumericValue(monthCharArray[1]);

        if(firstDigitInMonth == 0 || firstDigitInMonth == 1){
            year = "19" + year;
        }
        else if(firstDigitInMonth == 2 || firstDigitInMonth == 3){
            year = "20" + year;
            if(firstDigitInMonth == 2 ) month = "0" + lastDigitInMonth;
            else month = "1" + lastDigitInMonth;
        }

        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);

       return LocalDate.of(yearInt, monthInt, dayInt);
    }
    private Gender readGenderFromPersonalNumber(Worker worker){
        String personalNumber = worker.getPesel();
        char genderCharInPersonalNumber = personalNumber.charAt(9);

        if (Character.getNumericValue(genderCharInPersonalNumber) % 2 == 0)
            return Gender.K;
        else return Gender.M;
    }
    private Integer getWorkersAgeFromBirthData(LocalDate birthDate){
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        return period.getYears();
    }

}
