package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts.NewPositionDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NewPositionTypeDialog extends Dialog implements ComponentCreator {
    // To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;

    //  To configure
    NewPositionDialogLayout newPositionDialogLayout;

    @Override
    public void configureComponents() {
        configureNewPositionDialogLayout();
    }
    @Override
    public void configureFront() {
        add(newPositionDialogLayout);
        open();
    }
    private void configureNewPositionDialogLayout(){
        newPositionDialogLayout = new NewPositionDialogLayout(
                this,
                positionService,
                manageCompanyDialog,
                notification
        );
        newPositionDialogLayout.configure();
    }
}
