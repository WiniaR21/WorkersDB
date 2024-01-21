package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.layouts.DialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class ManageCompanyDialog extends Dialog implements ComponentCreator {
    private final PositionService positionService;
    public ManageCompanyDialog(PositionService positionService) {
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    //  To configure
    DialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(this, positionService);
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
}
