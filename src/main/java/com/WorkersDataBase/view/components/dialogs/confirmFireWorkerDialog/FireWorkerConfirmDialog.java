package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.layouts.FireWorkerConfirmDialogLayout;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  Components
    private final ServicePushNotification notification;
    private final WorkersGrid workersGrid;
    private final EditWorkerDialog editWorkerDialog;
    private final Worker workerSelectedFromGrid;
    //  Services
    private final WorkerDeleteService workerDeleteService;

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
                notification,
                workersGrid,
                this,
                editWorkerDialog,
                workerSelectedFromGrid,
                workerDeleteService
        );
        dialogLayout.configure();
    }
}
