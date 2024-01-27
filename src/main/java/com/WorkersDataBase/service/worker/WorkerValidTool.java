package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.validTools.StringValidTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerValidTool {

    private final StringValidTool stringValidTool;
    private final WorkerRepository workerRepository;
    private final ContactRepository contactRepository;

    public boolean workerHasNotEmptyFields(Worker worker){
        if (
                        worker.getContact() == null ||
                        worker.getFirstName() == null ||
                        worker.getLastName() == null ||
                        worker.getPesel() == null
        ) return false;

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
    public boolean peselIsUnique(Worker worker) {
        return !workerRepository.existsByPesel(worker.getPesel());
    }
    public boolean emailIsUnique(Worker worker){
        return !contactRepository.existsByEmail(worker.getContact().getEmail());
    }
    public boolean peselLengthIsFine(Worker worker){
        return worker.getPesel().length() == 11;
    }
}
