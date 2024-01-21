package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog;

import com.WorkersDataBase.service.contract.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.layouts.NewPositionDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class NewPositionTypeDialog extends Dialog implements ComponentCreator {

    private final PositionService positionService;

    public NewPositionTypeDialog(PositionService positionService) {
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    //  To configure
    NewPositionDialogLayout newPositionDialogLayout;

    @Override
    public void configureComponents() {
        newPositionDialogLayout = new NewPositionDialogLayout(this, positionService);
    }

    @Override
    public void configureFront() {
        add(newPositionDialogLayout);
        open();
    }
}
