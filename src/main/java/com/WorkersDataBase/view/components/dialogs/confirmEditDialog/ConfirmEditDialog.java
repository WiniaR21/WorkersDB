package com.WorkersDataBase.view.components.dialogs.confirmEditDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.layouts.ConfirmEditDialogLayout;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ConfirmEditDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final WorkerPostService workerPostService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final Worker oryginalWorker;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    ConfirmEditDialogLayout dialogLayout;

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
        dialogLayout = new ConfirmEditDialogLayout(
                workerPostService,
                newWorker,
                workersGrid,
                this,
                oryginalWorker,
                editWorkerDialog,
                notification
        );
        dialogLayout.configure();
    }
}
