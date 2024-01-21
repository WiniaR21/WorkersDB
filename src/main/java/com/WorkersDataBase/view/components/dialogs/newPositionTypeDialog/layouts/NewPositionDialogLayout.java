package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.layouts;

import com.WorkersDataBase.service.contract.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.buttons.CancelNewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.buttons.SaveNewPositionType;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class NewPositionDialogLayout extends VerticalLayout implements ComponentCreator {
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final PositionService positionService;
    public NewPositionDialogLayout(
            NewPositionTypeDialog newPositionTypeDialog,
            PositionService positionService
    ) {
        this.newPositionTypeDialog = newPositionTypeDialog;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    //  To configure
    PositionNameField positionNameField;
    SaveNewPositionType saveNewPositionType;
    CancelNewPositionTypeDialog cancelNewPositionTypeDialog;

    @Override
    public void configureComponents() {
        positionNameField = new PositionNameField();
        cancelNewPositionTypeDialog = new CancelNewPositionTypeDialog(newPositionTypeDialog);
        saveNewPositionType = new SaveNewPositionType(positionNameField, positionService);
    }

    @Override
    public void configureFront() {
        add(positionNameField, saveNewPositionType, cancelNewPositionTypeDialog);
    }
}
