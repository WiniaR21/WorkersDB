package com.WorkersDataBase.view.components.dialogs.removePositionDialog;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts.RemovePositionDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final ManageCompanyDialog       manageCompanyDialog;
    //  Services
    private final PositionDeleteService     positionDeleteService;
    private final PositionGetService        positionGetService;

                //  To configure
                RemovePositionDialogLayout  dialogLayout;

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
                manageCompanyDialog,
                notification,
                this,
                positionDeleteService,
                positionGetService
        );
        dialogLayout.configure();
    }
}
