package com.WorkersDataBase.view.components.dialogs.addWorkerDialog;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.layouts.AddWorkerDialogLayout;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AddWorkerDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final WorkerPostService workerPostService;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;

    // To configure
    AddWorkerDialogLayout dialogLayout;

    @Override
    public void configureComponents(){
        setDialogLayout();
    }
    @Override
    public void configureFront(){
        setModal(true);
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        dialogLayout = new AddWorkerDialogLayout(
                workerPostService,
                workersGrid,
                this,
                notification
        );
        dialogLayout.configure();
    }
}
