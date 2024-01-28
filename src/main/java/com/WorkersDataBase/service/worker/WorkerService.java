package com.WorkersDataBase.service.worker;
import com.WorkersDataBase.data.worker.Gender;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.contract.ContractService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final WorkerValidTool workerValidTool;
    private final ContractService contractService;
    public Optional<Worker> getById(Long id){
        return workerRepository.findById(id);
    }
    public boolean workerWithIdExistInDB(Long id){
        return workerRepository.existsById(id);
    }
    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }


    @Transactional
    public int addWorker(Worker worker, boolean editingWorker){
        /*
        *       ERROR CODE
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
        *   -9 - error, control number in personalNumber failed
        */
        if( workerValidTool.workerIsNull(worker))          return -1;
        if( workerValidTool.workerHasEmptyFields(worker))  return -2;
        if(!workerValidTool.noSpecialSymbols(worker))      return -3;
        if(!workerValidTool.peselLengthIsFine(worker))     return -4;
        if(!workerValidTool.firstNameLengthIsFine(worker)) return -7;
        if(!workerValidTool.lastNameLengthIsFine(worker))  return -8;
        if(!workerValidTool.peselIsPossible(worker))       return -9;

        if(editingWorker){
            worker.setBirthDate(readBirthDateFromPersonalNumber(worker));
            worker.setGender(readGenderFromPersonalNumber(worker));
            workerRepository.save(worker);
            return 1;
        }

        if (!workerValidTool.peselIsUnique(worker))       return -5;
        if (!workerValidTool.emailIsUnique(worker))       return -6;

        worker.setGender(readGenderFromPersonalNumber(worker));
        worker.setBirthDate(readBirthDateFromPersonalNumber(worker));
        workerRepository.save(worker);
        return 0;
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
                            contractService.removeOldContract(worker);
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
    public List<Worker> getWorkersWithoutContract() {
        List<Worker> workersWithoutContract = new ArrayList<>();
        workerRepository.findAll().forEach(worker -> {
            if(worker.getContract() != null){
                workersWithoutContract.add(worker);
            }
        });
        return workersWithoutContract;
    }
}
