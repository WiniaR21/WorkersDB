package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.companyFee.CompanyFee;
import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.data.workersFee.WorkersFee;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ContractPostService {
    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;
    private final ContractValidTool contractValidTool;
    private final ContractDeleteService contractDeleteService;

    /*       STATUS CODE
    *    1 - change contract success
    *    0 - write contract success
    *   -1 - error, positionName is null
    *   -2 - error, salary less minimal 4242 PLN
    *   -3 - error, startDate is null
    *   -4 - error, endDate is null */
    @Transactional
    public int writeContractWithWorker(
            Worker worker,
            String positionName,
            double salary,
            LocalDate startDate,
            LocalDate endDate
    ) {
        if(positionName == null) return -1;
        if(!contractValidTool.validSalary(salary))                  return -2;
        if(!contractValidTool.dateIsFine(startDate))                return -3;
        if(!contractValidTool.dateIsFine(endDate))                  return -4;

        if (contractValidTool.workerHasContract(worker)) {
            contractDeleteService.removeOldContract(worker);
            writeNewContract(
                    worker,
                    positionName,
                    salary,
                    startDate,
                    endDate
            );
            return 1;
        }
        else writeNewContract(
                worker,
                positionName,
                salary,
                startDate,
                endDate
        );
        return 0;

    }
    private void writeNewContract(Worker worker,
                                  String positionName,
                                  double salary,
                                  LocalDate startDate,
                                  LocalDate endDate
    ) {
        //  Write new contract based on data provided by user
        Contract contract = new Contract();
        contract.setWorker(worker);
        contract.setSalary(salary);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);

        //  Calculate companyFee
        CompanyFee companyFee = new CompanyFee(salary);
        companyFee.setContract(contract);
        contract.setCompanyFee(companyFee);

        //  Calculate workersFee
        WorkersFee workersFee = new WorkersFee(salary, worker.getAge());
        workersFee.setContract(contract);
        contract.setWorkersFee(workersFee);

        //  Add dependencies in DB
        positionRepository.getPositionsByPositionName(positionName).ifPresent(
                position -> {
                    contract.setPosition(position);
                    contractRepository.save(contract);
                }

        );

        positionRepository.getPositionsByPositionName(positionName).ifPresent(
                position -> {
                    position.getContracts().add(contract);
                    positionRepository.save(position);
                }
        );

        worker.setContract(contract);
        workerRepository.save(worker);

    }

}

