package com.WorkersDataBase.view.components.dialogs.removePositionDialog;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.layouts.RemovePositionLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class RemovePositionDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;

    public RemovePositionDialog(
            PositionService positionService,
            ManageCompanyDialog manageCompanyDialog
    ) {
        this.positionService = positionService;
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    //  To configure
    RemovePositionLayout removePositionLayout;
    @Override
    public void configureComponents() {
        removePositionLayout = new RemovePositionLayout(
                positionService,
                this,
                manageCompanyDialog
        );
    }

    @Override
    public void configureFront() {
        add(removePositionLayout);
        open();
    }
}
