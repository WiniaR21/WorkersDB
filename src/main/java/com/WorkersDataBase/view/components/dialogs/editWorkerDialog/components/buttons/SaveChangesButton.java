package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.FieldsLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;


import java.util.Optional;

public class SaveChangesButton extends Button implements ComponentCreator, ButtonCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final FieldsLayout fieldsLayout;
    private final Worker workerSelectedFromGrid;

    public SaveChangesButton(
            WorkerService workerService,
            WorkersGrid workersGrid,
            EditWorkerDialog editWorkerDialog,
            FieldsLayout fieldsLayout,
            Worker workerSelectedFromGrid
    ) {
        this.workerService = workerService;
        this.editWorkerDialog = editWorkerDialog;
        this.workersGrid = workersGrid;
        this.fieldsLayout = fieldsLayout;
        this.workerSelectedFromGrid = workerSelectedFromGrid;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {

        if(workerService.workerWithIdExistInDB(workerSelectedFromGrid.getId())){
            Optional<Worker> original = workerService.getById(workerSelectedFromGrid.getId());
            Worker newWorker = getWorkerFromUser();

            original.ifPresent(originalWorker ->
                    new ConfirmEditDialog(
                            workerService,
                            newWorker,
                            workersGrid,
                            originalWorker
                    ));
            editWorkerDialog.close();
        }

    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zapisz");
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickListener(buttonClickEvent -> clickEvent());
    }
    private Worker getWorkerFromUser(){
        workerSelectedFromGrid
                .setFirstName(fieldsLayout.getFirstNameField().getValue());

        workerSelectedFromGrid
                .setLastName(fieldsLayout.getLastNameField().getValue());

        workerSelectedFromGrid
                .setPesel(fieldsLayout.getPeselField().getValue());

        workerSelectedFromGrid.getContact()
                .setEmail(fieldsLayout.getEmailField().getValue());

        return workerSelectedFromGrid;
    }
}
