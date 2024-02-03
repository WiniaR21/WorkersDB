package com.WorkersDataBase.service.tools;

import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkerValidTool {

    private final WorkerRepository workerRepository;
    private final ContactRepository contactRepository;
    public boolean workerHasEmptyFields(Worker worker){
        if (
                worker.getContact() == null || worker.getFirstName() == null ||
                worker.getLastName() == null || worker.getPersonalNumber() == null
        ) return true;

        return  worker.getContact().getEmail().isEmpty() ||
                worker.getFirstName().isEmpty() ||
                worker.getLastName().isEmpty() ||
                worker.getPersonalNumber().isEmpty();
    }

    public boolean noSpecialSymbols(Worker worker){
        return  isStringLetters(worker.getFirstName()) &&
                isStringLetters(worker.getLastName()) &&
                isStringDigits(worker.getPersonalNumber());
    }
    public boolean emailIsUnique(Worker worker){
        return !contactRepository.existsByEmail(worker.getContact().getEmail());
    }
    public boolean personalNumberIsUnique(Worker worker) {
        return !workerRepository.existsByPesel(worker.getPersonalNumber());
    }
    public boolean personalNumberLengthIsFine(Worker worker){
        return worker.getPersonalNumber().length() == 11;
    }

    public boolean personalNumberIsPossible(Worker worker){

        char[] digitsArray = worker.getPersonalNumber().toCharArray();
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

    public boolean isStringLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
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
}
