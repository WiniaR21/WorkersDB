package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.CancelNewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.SaveNewPositionType;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class NewPositionDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    public NewPositionDialogLayout(
            NewPositionTypeDialog newPositionTypeDialog,
            PositionService positionService,
            ManageCompanyDialog manageCompanyDialog
    ) {
        this.newPositionTypeDialog = newPositionTypeDialog;
        this.positionService = positionService;
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    //  To configure
    PositionNameField positionNameField;
    SaveNewPositionType saveNewPositionType;
    CancelNewPositionTypeDialog cancelNewPositionTypeDialog;
    H3 header;

    @Override
    public void configureComponents() {
        header = new H3("Nowe stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        positionNameField = new PositionNameField();

        cancelNewPositionTypeDialog = new CancelNewPositionTypeDialog(
                newPositionTypeDialog, manageCompanyDialog);

        saveNewPositionType = new SaveNewPositionType(positionNameField, positionService);
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                positionNameField,

                new HorizontalLayout(saveNewPositionType, cancelNewPositionTypeDialog));
    }
}
