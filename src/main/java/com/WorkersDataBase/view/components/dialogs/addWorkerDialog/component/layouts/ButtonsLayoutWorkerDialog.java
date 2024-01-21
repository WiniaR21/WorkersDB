package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts;

import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons.SaveWorkerButton;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons.CloseDialogButton;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;

@Getter
public class ButtonsLayoutWorkerDialog extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final AddWorkerDialog addWorkerDialog;
    private final WorkersGrid workersGrid;
    private final FieldsLayout fieldsLayout;

    public ButtonsLayoutWorkerDialog(
            WorkerService workerService,
            AddWorkerDialog addWorkerDialog,
            WorkersGrid workersGrid,
            FieldsLayout fieldsLayout
    ){
        this.workerService = workerService;
        this.addWorkerDialog = addWorkerDialog;
        this.workersGrid = workersGrid;
        this.fieldsLayout = fieldsLayout;

        configureComponents();
        configureFront();
    }

    // To configure
    SaveWorkerButton saveWorkerButton;
    CloseDialogButton closeDialogButton;

    @Override
    public void configureComponents(){
        saveWorkerButton = new SaveWorkerButton(workerService, fieldsLayout, workersGrid, addWorkerDialog);
        closeDialogButton = new CloseDialogButton(addWorkerDialog, workersGrid);
    }
    @Override
    public void configureFront(){
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(
                saveWorkerButton,
                closeDialogButton
        );
    }
}
