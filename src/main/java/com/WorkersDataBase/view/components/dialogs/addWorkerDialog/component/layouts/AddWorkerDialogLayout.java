package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts;

import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons.CloseDialogButton;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons.SaveWorkerButton;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersPeselField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddWorkerDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;

    public AddWorkerDialogLayout(
            WorkerService workerService,
            WorkersGrid workersGrid, AddWorkerDialog addWorkerDialog
    ) {
        this.workerService = workerService;
        this.workersGrid = workersGrid;
        this.addWorkerDialog = addWorkerDialog;


        configureComponents();
        configureFront();
    }
    //  To configure
    H3 header;

    WorkersFirstNameField workersFirstNameField;
    WorkersLastNameField workersLastNameField;
    WorkersEmailField workersEmailField;
    WorkersPeselField workersPeselField;
    VerticalLayout fieldsLayout;


    SaveWorkerButton saveWorkerButton;
    CloseDialogButton closeDialogButton;
    HorizontalLayout buttonsLayout;

    @Override
    public void configureComponents() {

        header = new H3("Dodaj pracownika");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");


        configureFields();
        configureFieldsLayout();

        configureButtons();
        configureButtonsLayout();




    }


    private void configureButtons() {
        saveWorkerButton = new SaveWorkerButton(
                workerService,
                workersGrid,
                addWorkerDialog,
                workersFirstNameField,
                workersLastNameField,
                workersEmailField,
                workersPeselField
        );
        saveWorkerButton.configureComponents();
        saveWorkerButton.configureFront();

        closeDialogButton = new CloseDialogButton(addWorkerDialog);
        closeDialogButton.configureComponents();
        closeDialogButton.configureFront();
    }
    private void configureButtonsLayout() {
        buttonsLayout = new HorizontalLayout(saveWorkerButton, closeDialogButton);
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
    }


    @Override
    public void configureFront(){
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
        getStyle().set("width", "300px").set("max-width", "100%");
        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }
    private void configureFields() {
        workersFirstNameField = new WorkersFirstNameField();
        workersLastNameField = new WorkersLastNameField();
        workersEmailField = new WorkersEmailField();
        workersPeselField = new WorkersPeselField();
    }
    private void configureFieldsLayout(){
        fieldsLayout = new VerticalLayout(
                workersFirstNameField,
                workersLastNameField,
                workersEmailField,
                workersPeselField
        );

        fieldsLayout.setAlignItems(Alignment.CENTER);
        fieldsLayout.setSpacing(false);
        fieldsLayout.setPadding(false);
        fieldsLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
    }
}
