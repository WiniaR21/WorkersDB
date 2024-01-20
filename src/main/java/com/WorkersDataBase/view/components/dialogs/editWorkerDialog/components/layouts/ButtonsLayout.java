package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.CancelChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.SaveChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.WritteContractButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;

@Getter
public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final FieldsLayout fieldsLayout;
    private final Worker workerSelectedFromGrid;

    public ButtonsLayout(
            WorkerService workerService,
            WorkersGrid workersGrid,
            EditWorkerDialog editWorkerDialog,
            FieldsLayout fieldsLayout, Worker workerSelectedFromGrid
    ) {
        this.workerService = workerService;
        this.workersGrid = workersGrid;
        this.editWorkerDialog = editWorkerDialog;
        this.fieldsLayout = fieldsLayout;
        this.workerSelectedFromGrid = workerSelectedFromGrid;

        configureComponents();
        configureFront();
    }

    // To configure
    SaveChangesButton saveChangesButton;
    CancelChangesButton cancelChangesButton;
    WritteContractButton writteContractButton;

    @Override
    public void configureComponents() {
        saveChangesButton = new SaveChangesButton(
                workerService,
                workersGrid,
                editWorkerDialog,
                fieldsLayout,
                workerSelectedFromGrid
        );

        cancelChangesButton = new CancelChangesButton(
                editWorkerDialog
        );

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
