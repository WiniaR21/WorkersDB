package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionPostService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts.NewPositionDialogTypeLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NewPositionTypeDialog extends Dialog implements ComponentCreator, DialogCreator {
    // To inject by constructor
    private final PositionPostService positionPostService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;

    //  To configure
    NewPositionDialogTypeLayout dialogLayout;

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
        dialogLayout = new NewPositionDialogTypeLayout(
                this,
                positionPostService,
                manageCompanyDialog,
                notification
        );
        dialogLayout.configure();
    }
}
