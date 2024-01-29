package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.companyFee.CompanyFee;
import com.WorkersDataBase.data.companyFee.CompanyFeeRepository;
import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;
    private final CompanyFeeRepository companyFeeRepository;
    private final ContractValidTool contractValidTool;

    /*
    *   RETURN CODE
    *   1 - change contract success
    *   0 - write contract success
    *   -1 - error, positionName is null
    *   -2 - error, salary minimal is 4242 PLN
    *   -3 - error, startDate is null
    *   -4 - error, endDate is null
    */
    @Transactional
    public int writeContractWithWorker(
            Worker worker,
            String positionName,
            double salary,
            LocalDate startDate,
            LocalDate endDate
    ) {
        //  Valid
        //  * It is impossible to provide null worker, so valid do not needed
        if(!contractValidTool.positionNameIsFine(positionName))     return -1;
        if(!contractValidTool.validSalary(salary))                  return -2;
        if(!contractValidTool.dateIsFine(startDate))                return -3;
        if(!contractValidTool.dateIsFine(endDate))                  return -4;


        if (contractValidTool.workerHasContract(worker)) {
            removeOldContract(worker);
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
    @Transactional
    public void removeOldContract(Worker worker) {
        //  Get old contract from worker and remove dependencies
            //  For now delete, but of course is possible to storage old contract in DB
        Position position = worker.getContract().getPosition();

        Contract contractToRemove = worker.getContract();
        position.getContracts().remove(contractToRemove);

        worker.setContract(null);

        workerRepository.save(worker);
        positionRepository.save(position);

    }

    private void writeNewContract(Worker worker, String positionName, double salary, LocalDate startDate, LocalDate endDate) {
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

