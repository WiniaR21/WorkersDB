package com.WorkersDataBase.service.Notification;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
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

    //  Info
    public void pushDeletingPositionConflictInfo(){
        new InfoNotification("Ktoś ma to stanowisko na umowie. Najpierw rozwiąż ten problem");
    }
    public void pushNationalLowestInfo() {
        new InfoNotification("Najniższa krajowa to 4242 PLN");
    }

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


}
