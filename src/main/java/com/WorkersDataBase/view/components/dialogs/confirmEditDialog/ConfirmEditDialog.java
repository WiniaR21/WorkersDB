package com.WorkersDataBase.view.components.dialogs.confirmEditDialog;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts.DialogLayout;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ConfirmEditDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final Worker oryginalWorker;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    DialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        configureDialogLayout();
    }
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
    private void configureDialogLayout(){
        dialogLayout = new DialogLayout(
                workerService,
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
