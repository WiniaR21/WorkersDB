package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;


import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.EditWorkerDialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EditWorkerDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  Components
    private final ServicePushNotification notification;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    //  Services
    private final WorkerPostService workerPostService;
    private final PositionGetService positionGetService;
    private final ContractPostService contractPostService;
    private final WorkerDeleteService workerDeleteService;
    private final WorkerGetService workerGetService;

    //  To configure
    EditWorkerDialogLayout dialogLayout;

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
        dialogLayout = new EditWorkerDialogLayout(
                notification,
                this,
                workersGrid,
                workerSelectedFromGrid,
                positionGetService,
                workerPostService,
                contractPostService,
                workerDeleteService,
                workerGetService
        );
        dialogLayout.configure();
    }
}
