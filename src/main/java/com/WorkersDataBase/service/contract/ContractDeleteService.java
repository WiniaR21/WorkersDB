package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractDeleteService {
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;

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
}
