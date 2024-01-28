package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.layouts.ManageCompanyDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageCompanyDialog extends Dialog implements ComponentCreator {
    private final PositionService positionService;
    private final ServicePushNotification notification;

    //  To configure
    ManageCompanyDialogLayout manageCompanyDialogLayout;

    @Override
    public void configureComponents() {
       configureManageCompanyDialogLayout();
    }
    @Override
    public void configureFront() {
        add(manageCompanyDialogLayout);
        open();
    }
    private void configureManageCompanyDialogLayout(){
        manageCompanyDialogLayout =
                new ManageCompanyDialogLayout(
                        this,
                        positionService,
                        notification
                );
        manageCompanyDialogLayout.configure();
    }
}
