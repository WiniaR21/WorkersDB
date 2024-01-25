package com.WorkersDataBase.service.worker;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.Notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final ServicePushNotification notification;
    private final WorkerValidTool workerValidTool;

    public Optional<Worker> getById(Long id){
        return workerRepository.findById(id);
    }
    public boolean workerWithIdExistInDB(Long id){
        return workerRepository.existsById(id);
    }
    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }


    //  addWorker returns true if adding was successful
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

        if (workerValidTool.workerHasNotNullFields(worker)) {
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
        if (!workerValidTool.peselIsPossible(worker)){
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

}
