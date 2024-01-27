package com.WorkersDataBase.service.worker;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final ServicePushNotification notification;
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
    public boolean addWorker(Worker worker, boolean editingWorker){
        boolean workerIsNotNull = worker != null;

        if (workerIsNotNull) {
           return startAddingProcedure(worker, editingWorker);
        }
        else {
            notification.pushError();
            return false;
        }
    }
        private boolean startAddingProcedure(Worker worker, boolean editingWorker){

        if (workerValidTool.workerHasNotEmptyFields(worker)) {
            return validWorker(worker, editingWorker);
        }
        else {
            notification.pushEmptyFieldsError();
            return false;
        }
    }
        private boolean validWorker(Worker worker, boolean editingWorker){

        if (workerValidTool.noSpecialSymbols(worker)) {
            return tryAddWorker(worker, editingWorker);
        }
        else {
            notification.pushSpecialSymbolsError();
            return false;
        }
    }
        private boolean tryAddWorker(Worker worker, boolean editingWorker) {
        if (!workerValidTool.peselLengthIsFine(worker)){
            notification.pushPeselLengthError();
            return false;
        }
        if(editingWorker){
            workerRepository.save(worker);
            notification.pushEditSuccess();
            return true;
        }

        if (!workerValidTool.peselIsUnique(worker)){
            notification.pushPeselUniqueError();
            return false;
        }
        if (!workerValidTool.emailIsUnique(worker)){
            notification.pushEmailUniqueError();
            return false;
        }
        workerRepository.save(worker);
        notification.pushAddingWorkerSuccess(worker);
        return true;

    }
    @Transactional
    public boolean fireWorker(Long idWorkerToFire){

        if(!workerRepository.existsById(idWorkerToFire)){
            notification.pushError();
            return false;
        }
        workerRepository.findById(idWorkerToFire).ifPresent(
                worker -> {
                        if (worker.getContract() != null){
                            contractService.removeOldContract(worker);
                            workerRepository.deleteById(idWorkerToFire);
                            notification.pushFireWorkerSucces(worker);
                        }
                        else {
                            workerRepository.deleteById(idWorkerToFire);
                        }
                }
        );
        return true;
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
