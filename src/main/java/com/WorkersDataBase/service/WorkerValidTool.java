package com.WorkersDataBase.service;

import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import org.springframework.stereotype.Component;

@Component
public class WorkerValidTool {

    public boolean workerHasNotNullFields(Worker worker){
        return  !worker.getContact().getEmail().isEmpty() &&
                !worker.getFirstName().isEmpty() &&
                !worker.getLastName().isEmpty() &&
                !worker.getPesel().isEmpty();
    }
    public boolean noSpecialSymbols(Worker worker){
        return  isStringLetters(worker.getFirstName()) &&
                isStringLetters(worker.getLastName()) &&
                isStringDigits(worker.getPesel());
    }
    public boolean peselAndEmailUnique(
            Worker worker,
            WorkerRepository workerRepository,
            ContactRepository contactRepository
    ) {

        String email = worker.getContact().getEmail();
        boolean emailIsUnique = !contactRepository.existsByEmail(email);
        String pesel = worker.getPesel();
        boolean peselIsUnique = !workerRepository.existsByPesel(pesel);

        return  peselIsUnique && emailIsUnique;
    }
    private boolean isStringLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean isStringDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
