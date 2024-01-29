package com.WorkersDataBase.service.notification;

import com.WorkersDataBase.data.contract.position.Position;
import com.WorkersDataBase.data.contract.worker.Worker;
import org.springframework.stereotype.Component;

@Component
public class ServicePushNotification{
    //  Success
    public void pushEditSuccess(){
        new SuccessNotification("Edycja powiodła się");
    }
    public void pushAddingWorkerSuccess(Worker worker){
        String message =
                String.format("Zatrudniono %s %s", worker.getFirstName(), worker.getLastName());
        new SuccessNotification(message);
    }
    public void pushChangeContractSuccess(Worker worker){
        String message =
                String.format("%s %s ma nową umowę", worker.getFirstName(), worker.getLastName());
        new SuccessNotification(message);
    }
    public void pushWriteContractSuccess(Worker worker){
        String message =
                String.format(
                        "Od teraz %s %s ma umowę", worker.getFirstName(), worker.getLastName());
        new SuccessNotification(message);
    }
    public void pushDeletePositionSuccess(Position position){
        String message =
                String.format("Usunięto stanowisko %s", position.getPositionName());
        new SuccessNotification(message);
    }
    public void pushNewPositionSuccess(String positionName){
        String message =
                String.format("Utworzono stanowisko %s w firmie", positionName);
        new SuccessNotification(message);
    }
    public void pushFireWorkerSucces(Worker worker) {
        String message =
                String.format("%s %s został zwolniony", worker.getFirstName(), worker.getLastName());
        new SuccessNotification(message);
    }
    public void pushBreachContractSuccess(Worker worker) {
        String message =
                String.format("Zerwano umowę z %s %s", worker.getFirstName(), worker.getLastName());
        new SuccessNotification(message);
    }

    //  Info
    public void pushDeletingPositionConflictInfo(){
        new InfoNotification("Ktoś ma to stanowisko na umowie. Najpierw rozwiąż ten problem");
    }
    public void pushNationalLowestInfo() {
        new InfoNotification("Najniższa krajowa to 4242 PLN");
    }
    public void pushUserTryingAddNullPositionInfo() {
        new InfoNotification("Nie podano nazwy stanowiska");
    }
    public void pushToShortPositionNameInfo() {
        new InfoNotification("Nazwa jest za krótka");
    }
    public void pushFirstNameIsToShortInfo() {new InfoNotification("Imie jest za krótkie");}
    public void pushLastNameIsToShortInfo() {new InfoNotification("Nazwisko jest za krótkie");}


    //  Errors
    public void pushPeselLengthError(){
        new ErrorNotification("Pesel powinien mieć 11 cyfr");
    }
    public void pushPeselUniqueError(){
        new ErrorNotification("Pesel powinien być unikalny");
    }
    public void pushEmailUniqueError(){
        new ErrorNotification("Email powinien być unikalny");
    }
    public void pushSpecialSymbolsError(){
        new ErrorNotification("Usuń znaki specjalne");
    }
    public void pushEmptyFieldsError(){
        new ErrorNotification("Uzupełnij wymagane pola");
    }
    public void pushUniquePositionError(){
        new ErrorNotification("Stanowisko powinno mieć unikalną nazwę");
    }
    public void pushError() {
       new ErrorNotification("Coś poszło nie tak");
    }
    public void pushStartDateError(){new ErrorNotification("Wprowadź datę rozpoczęcia umowy");}
    public void pushEndDateError(){new ErrorNotification("Wprowadź datę zakończenia umowy");}
    public void pushPositionNameIsNull(){new ErrorNotification("Podaj stanowisko");}
    public void pushPeselControlNumberError() {
        new ErrorNotification("Literówka w numerze pesel");
    }


}
