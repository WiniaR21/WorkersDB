package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;

    public boolean writeContractWithWorker(Worker worker, Contract contract){
        worker.setContract(contract);
        contractRepository.save(contract);
        workerRepository.save(worker);
        return true;
    }

}
