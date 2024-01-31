package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.layouts.FireWorkerConfirmDialogLayout;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final ServicePushNotification notification;

    //  To configure
    FireWorkerConfirmDialogLayout dialogLayout;
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
        dialogLayout = new FireWorkerConfirmDialogLayout(
                workerService,
                workersGrid,
                workerSelectedFromGrid,
                this,
                editWorkerDialog,
                notification
        );
        dialogLayout.configure();
    }
}
