package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.contract.ContractDeleteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerDeleteService {
    private final WorkerRepository workerRepository;
    private final ContractDeleteService contractDeleteService;
    @Transactional
    public int fireWorker(Long idWorkerToFire){
        /*
         *       ERROR CODE
         *    0 - removing success
         *   -1 - error, worker do not exist in DB
         */
        if(workerDoNotExist(idWorkerToFire)) return -1;

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
    boolean workerDoNotExist(Long id){
        return !workerRepository.existsById(id);
    }
}
