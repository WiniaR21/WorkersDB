package com.WorkersDataBase.service.validTools;

import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerValidTool {

    private final StringValidTool stringValidTool;

    public boolean workerHasNotNullFields(Worker worker){
        return  !worker.getContact().getEmail().isEmpty() &&
                !worker.getFirstName().isEmpty() &&
                !worker.getLastName().isEmpty() &&
                !worker.getPesel().isEmpty();
    }
    public boolean noSpecialSymbols(Worker worker){
        return  stringValidTool.isStringLetters(worker.getFirstName()) &&
                stringValidTool.isStringLetters(worker.getLastName()) &&
                stringValidTool.isStringDigits(worker.getPesel());
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

}
