package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.contract.contact.ContactRepository;
import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.data.contract.worker.WorkerRepository;
import com.WorkersDataBase.service.validTools.StringValidTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerValidTool {

    private final StringValidTool stringValidTool;
    private final WorkerRepository workerRepository;
    private final ContactRepository contactRepository;
    public boolean workerIsNull(Worker worker){
        return worker == null;
    }
    public boolean workerHasEmptyFields(Worker worker){
        if (
                worker.getContact() == null || worker.getFirstName() == null ||
                worker.getLastName() == null || worker.getPesel() == null
        ) return true;

        return  worker.getContact().getEmail().isEmpty() ||
                worker.getFirstName().isEmpty() ||
                worker.getLastName().isEmpty() ||
                worker.getPesel().isEmpty();
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

    boolean peselIsPossible(Worker worker){

        char[] digitsArray = worker.getPesel().toCharArray();
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int controlNumberInOriginal = Character.getNumericValue(digitsArray[10]);
        int sum = 0;

        for(int i = 0; i < 10; i++){
            int digit = Character.getNumericValue(digitsArray[i]);
            sum += digit * weights[i];
        }

        int rest = sum % 10;
        int controlNumberShouldBe = rest == 0 ? 0 : 10 - rest;

        return controlNumberInOriginal == controlNumberShouldBe;
    }
    public boolean firstNameLengthIsFine(Worker worker){
        return worker.getFirstName().length() > 2;
    }
    public boolean lastNameLengthIsFine(Worker worker){
        return worker.getLastName().length() > 2;
    }
}
