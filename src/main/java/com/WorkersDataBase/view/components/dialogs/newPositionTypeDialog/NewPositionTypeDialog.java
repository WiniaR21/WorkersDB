package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts.NewPositionDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class NewPositionTypeDialog extends Dialog implements ComponentCreator {
    // To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;

    public NewPositionTypeDialog(
            PositionService positionService,
            ManageCompanyDialog manageCompanyDialog
    ) {
        this.positionService = positionService;
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    //  To configure
    NewPositionDialogLayout newPositionDialogLayout;

    @Override
    public void configureComponents() {
        newPositionDialogLayout = new NewPositionDialogLayout(
                this, positionService, manageCompanyDialog);
    }

    @Override
    public void configureFront() {
        add(newPositionDialogLayout);
        open();
    }
}