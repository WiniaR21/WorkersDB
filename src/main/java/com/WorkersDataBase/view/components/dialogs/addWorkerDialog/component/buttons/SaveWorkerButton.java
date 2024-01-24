package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersPeselField;
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
public class SaveWorkerButton extends Button implements ComponentCreator, ButtonCreator {

    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;
    private final WorkersFirstNameField firstNameField;
    private final WorkersLastNameField lastNameField;
    private final WorkersEmailField emailField;
    private final WorkersPeselField peselField;

    @Override
    public void clickEvent() {
        addWorkerToDB();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        addClickShortcut(Key.ENTER);
    }

    private void addWorkerToDB(){
        Worker worker = getWorkerFromUser();
        boolean operationSuccess = workerService.addWorker(worker, false);
        if(operationSuccess){
            workersGrid.refresh();
            addWorkerDialog.close();
        }
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


}
