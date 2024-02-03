package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.buttons;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersPeselField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class SaveWorkerButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final WorkerPostService workerPostService;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;
    private final WorkersFirstNameField firstNameField;
    private final WorkersLastNameField lastNameField;
    private final WorkersEmailField emailField;
    private final WorkersPeselField peselField;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        addWorkerToDB();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        addClickShortcut(Key.ENTER);
    }
    private void addWorkerToDB(){
        int status = workerPostService.addWorker(getWorkerFromUser(), false);
        statusResponse(status);
    }
    private Worker getWorkerFromUser(){
        Contact contact = new Contact(emailField.getValue());

        return new Worker(
                firstNameField.getValue(),
                lastNameField.getValue(),
                peselField.getValue(),
                contact
        );
    }
    private void statusResponse(int status){
        if (status ==  1) notification.pushEditSuccess();
        if (status ==  0) notification.pushAddingWorkerSuccess(getWorkerFromUser());
        if (status == -1) notification.pushError();
        if (status == -2) notification.pushEmptyFieldsError();
        if (status == -3) notification.pushSpecialSymbolsError();
        if (status == -4) notification.pushPeselLengthError();
        if (status == -5) notification.pushPeselUniqueError();
        if (status == -6) notification.pushEmailUniqueError();
        if (status == -7) notification.pushFirstNameIsToShortInfo();
        if (status == -8) notification.pushLastNameIsToShortInfo();
        if (status == -9) notification.pushPeselControlNumberError();

        if (status == 0){
            workersGrid.refresh();
            addWorkerDialog.close();
        }
    }
}
