package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ContractService {
    private final ContractValidTool contractValidTool;
    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;
    private final ServicePushNotification notification;


    @Transactional
    public boolean writeContractWithWorker(
            Worker worker,
            String positionName,
            double salary,
            LocalDate startDate,
            LocalDate endDate
    ) {
        //  Valid
        //  * It is impossible to provide null worker, so valid do not needed
        //  * It is impossible to provide wrong positionName, so valid do not needed

        if (!contractValidTool.validSalary(salary)){
            notification.pushNationalLowestInfo();
            return false;
        }
        if(!contractValidTool.dateIsFine(startDate)){

            return false;
        }

        if (contractValidTool.workerHasContract(worker)) {
            removeOldContract(worker);
            writeNewContract(worker, positionName, salary, startDate, endDate);
            notification.pushChangeContractSuccess(worker);
        }
        else
        {
            writeNewContract(worker, positionName, salary, startDate, endDate);
            notification.pushWriteContractSuccess(worker);
        }
        return true;

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

        notification.pushBreachContractSuccess(worker);
    }

    private void writeNewContract(Worker worker, String positionName, double salary, LocalDate startDate, LocalDate endDate) {
        //  Write new contract based on data provided by user
        Contract contract = new Contract();
        contract.setWorker(worker);
        contract.setSalary(salary);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);

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

