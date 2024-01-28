package com.WorkersDataBase.view.components.dialogs.removePositionDialog;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.layouts.RemovePositionLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;


    //  To configure
    RemovePositionLayout removePositionLayout;

    @Override
    public void configureComponents() {
          configureRemovePositionLayout();
    }
    @Override
    public void configureFront() {
        add(removePositionLayout);
        open();
    }
    private void configureRemovePositionLayout(){
        removePositionLayout = new RemovePositionLayout(
                positionService,
                this,
                manageCompanyDialog,
                notification
        );
        removePositionLayout.configure();
    }
}
