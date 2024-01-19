package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.CancelChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.SaveChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.WritteContractButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;

@Getter
public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {

    // To inject by constructor
    FieldsLayout fieldsLayout;
    private final WorkerService workerService;

    // To configure
    SaveChangesButton saveChangesButton;
    CancelChangesButton cancelChangesButton;
    WritteContractButton writteContractButton;

    public ButtonsLayout(FieldsLayout fieldsLayout, WorkerService workerService) {
        this.workerService = workerService;
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        saveChangesButton = new SaveChangesButton(fieldsLayout, workerService);
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
