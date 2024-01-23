package com.WorkersDataBase.service.worker;
import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.ServicePushNotification;
import com.WorkersDataBase.service.validTools.WorkerValidTool;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final ContactRepository contactRepository;
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
            notification.pushError("Coś poszło nie tak");
            return false;
        }

    }
        private boolean startAddingProcedure(Worker worker, boolean editingWorker){

        if (workerValidTool.workerHasNotNullFields(worker)) {
            return validWorker(worker, editingWorker);
        }

        else {
            notification.pushError("Uzupełnij wymagane pola");
            return false;
        }

    }
        private boolean validWorker(Worker worker, boolean editingWorker){

        if (workerValidTool.noSpecialSymbols(worker)) {
            return tryAddWorker(worker, editingWorker);
        }

        else {
            notification.pushError("Usuń znaki specjalne");
            return false;
        }

    }
        private boolean tryAddWorker(Worker worker, boolean editingWorker) {

            if(editingWorker){
                workerRepository.save(worker);
                notification.pushSuccess("Edycja powiodła się");
                return true;
            }


            if (workerValidTool.peselAndEmailUnique(worker, workerRepository, contactRepository))
            {
                workerRepository.save(worker);
                notification.pushSuccess("Dodano nowego pracownika");
                return true;
            }
            else {
                notification.pushInfo("PESEL oraz Email powinny być unikalne");
                return false;
            }
    }




}
