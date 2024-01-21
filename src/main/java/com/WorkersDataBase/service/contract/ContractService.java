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

    @Transactional
    public boolean writeContractWithWorker(Worker worker, Contract contract, boolean workerHasContract){
        if (workerHasContract){

            Contract workersContract = worker.getContract();
            Long idContractToRemove = worker.getContract().getId();
            Long idPositionWhereRemoveContract = worker.getContract().getPosition().getId();

            //  Remove contract from worker
            worker.setContract(null);
            workerRepository.save(worker);

            // Remove worker from contract
            contractRepository.findById(idContractToRemove).ifPresent(
                    contractToRemove -> {
                        contractToRemove.setWorker(null);
                        contractRepository.save(contractToRemove);
                    }
            );

            // Remove contract from positions
            positionRepository.findById(idPositionWhereRemoveContract).ifPresent(position -> {
                position.getContracts().remove(workersContract);
                positionRepository.save(position);
            });

            contractRepository.delete(workersContract);
            // TODO prosze działaj

            worker.setContract(contract);
            contractRepository.save(contract);
            workerRepository.save(worker);
            System.out.println("Podmieniono");
            return true;

        }

        worker.setContract(contract);
        contractRepository.save(contract);
        workerRepository.save(worker);
        System.out.println("Nowy kotnrakt");
        return true;
    }

}
