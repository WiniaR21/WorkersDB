package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts.FieldsLayout;
import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.Setter;

@Setter
public class SaveWorkerButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final WorkerService service;
    private final FieldsLayout fieldsLayout;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;

    public SaveWorkerButton(
            WorkerService service,
            FieldsLayout fieldsLayout,
            WorkersGrid workersGrid,
            AddWorkerDialog addWorkerDialog
    ) {
        this.service = service;
        this.fieldsLayout = fieldsLayout;
        this.workersGrid = workersGrid;
        this.addWorkerDialog = addWorkerDialog;

        configureComponents();
        configureFront();
    }

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
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ENTER);
    }
    private void addWorkerToDB(){
        Worker worker = getWorkerFromUser();
        boolean operationSuccess = service.addWorker(worker, false);
        if(operationSuccess){
            workersGrid.refresh();
            addWorkerDialog.close();
        }

    }

    private Worker getWorkerFromUser(){
        Contact contact = new Contact(fieldsLayout.getWorkersEmailField().getValue());

        return new Worker(
                fieldsLayout.getWorkersFirstNameField().getValue(),
                fieldsLayout.getWorkersLastNameField().getValue(),
                fieldsLayout.getWorkersPeselField().getValue(),
                contact
        );
    }


}
