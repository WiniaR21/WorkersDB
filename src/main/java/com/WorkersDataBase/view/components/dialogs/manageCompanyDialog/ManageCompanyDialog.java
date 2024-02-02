package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.layouts.ManageCompanyDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageCompanyDialog extends Dialog implements ComponentCreator, DialogCreator {
    private final PositionService positionService;
    private final ServicePushNotification notification;

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
                        this,
                        positionService,
                        notification
                );
        dialogLayout.configure();
    }
}
