package com.WorkersDataBase.service;
import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final ContactRepository contactRepository;
    private final WorkerRepository workerRepository;
    private final ServicePushNotification notification;

    @Transactional
    public boolean addWorker(Worker worker){
        boolean workerIsNotNull = worker != null;
        if (workerIsNotNull) {
           return startAddingProcedure(worker);
        }
        else {
            notification.pushError("Coś poszło nie tak");
            return false;
        }
    }
    private boolean startAddingProcedure(Worker worker){
        boolean workerHasNotNullFields =
                !worker.getContact().getEmail().isEmpty() &&
                        !worker.getFirstName().isEmpty() &&
                        !worker.getLastName().isEmpty() &&
                        !worker.getPesel().isEmpty();

        if (workerHasNotNullFields) {
            return validWorker(worker);
        }
        else {
            notification.pushError("Uzupełnij wymagane pola");
            return false;
        }
    }
    private boolean validWorker(Worker worker){
        boolean fNameIsValid = isStringLetters(worker.getFirstName());
        boolean lNameIsValid = isStringLetters(worker.getLastName());
        boolean peselIsValid = isStringDigits(worker.getPesel());

        if (fNameIsValid && lNameIsValid && peselIsValid) {
            return tryAddWorker(worker);
        }
        else {
            notification.pushError("Usuń znaki specjalne");
            return false;
        }
    }
    private boolean tryAddWorker(Worker worker) {
        String email = worker.getContact().getEmail();
        boolean emailIsUnique = !contactRepository.existsByEmail(email);
        String pesel = worker.getPesel();
        boolean peselIsUnique = !workerRepository.existsByPesel(pesel);

        if (emailIsUnique && peselIsUnique) {
            workerRepository.save(worker);
            notification.pushSuccess("Dodano nowego pracownika");
            return true;
        }
        else {
            notification.pushInfo("PESEL oraz Email powinny być unikalne");
            return false;
        }
    }
    private boolean isStringLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    public boolean isStringDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }

}
