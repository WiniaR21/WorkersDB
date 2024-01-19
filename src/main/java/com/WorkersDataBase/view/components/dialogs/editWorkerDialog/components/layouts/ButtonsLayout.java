package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.CancelChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.SaveChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.WritteContractButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;

@Getter
public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {

    // To inject by constructor

    private final WorkerService workerService;
    EditWorkerDialog editWorkerDialog;

    // To configure
    SaveChangesButton saveChangesButton;
    CancelChangesButton cancelChangesButton;
    WritteContractButton writteContractButton;

    public ButtonsLayout(WorkerService workerService, EditWorkerDialog editWorkerDialog) {
        this.workerService = workerService;
        this.editWorkerDialog = editWorkerDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        saveChangesButton = new SaveChangesButton(workerService, editWorkerDialog);
        cancelChangesButton = new CancelChangesButton();
        writteContractButton = new WritteContractButton();
    }

    @Override
    public void configureFront() {
        add(
                saveChangesButton,
                cancelChangesButton,
                writteContractButton
        );
    }
}
