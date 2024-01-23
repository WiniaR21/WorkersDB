package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;

    //  writeContractWithWorker returns true if operation was success
    @Transactional
    public boolean writeContractWithWorker(
            Worker worker,
            String positionName,
            double salary,
            boolean workerHasContract
    ) {
        if (workerHasContract){
            removeOldContract(worker);
            Contract contract = writeContract(worker, positionName, salary);

            worker.setContract(contract);
            workerRepository.save(worker);

            return true;

        }
        return false;
    }

    private void removeOldContract(Worker worker) {
        //  Get old contract from worker and remove dependencies
        //      For now delete, but of course is possible to storage old contract in DB
        Position position = worker.getContract().getPosition();

        Contract contractToRemove = worker.getContract();
        position.getContracts().remove(contractToRemove);

        worker.setContract(null);

        workerRepository.save(worker);
        positionRepository.save(position);
    }

    private Contract writeContract(Worker worker, String positionName, double salary) {
        //  Write new contract based on data provided by user
        Contract contract = new Contract();
        contract.setWorker(worker);
        contract.setSalary(salary);

        //  Add dependencies
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

        return contract;
    }
}

