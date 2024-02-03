package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.service.position.PositionPostService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.layouts.ManageCompanyDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageCompanyDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  Components
    private final ServicePushNotification notification;
    //  Services
    private final PositionPostService positionPostService;
    private final PositionGetService positionGetService;
    private final PositionDeleteService positionDeleteService;

    //  To configure
    ManageCompanyDialogLayout dialogLayout;

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
        dialogLayout =
                new ManageCompanyDialogLayout(
                        notification,
                        this,
                        positionPostService,
                        positionDeleteService,
                        positionGetService
                );
        dialogLayout.configure();
    }
}
