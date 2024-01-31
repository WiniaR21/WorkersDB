package com.WorkersDataBase.view.components.dialogs.removePositionDialog;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts.RemovePositionDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;

    //  To configure
    RemovePositionDialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        setDialogLayout();
    }
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }

    @Override
    public void setDialogLayout() {
        dialogLayout = new RemovePositionDialogLayout(
                positionService,
                this,
                manageCompanyDialog,
                notification
        );
        dialogLayout.configure();
    }
}
