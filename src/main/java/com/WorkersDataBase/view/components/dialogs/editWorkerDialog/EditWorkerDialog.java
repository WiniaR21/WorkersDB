package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;


import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.EditWorkerDialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EditWorkerDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;
    private final ContractService contractService;
    private final ServicePushNotification notification;

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
                workerService,
                this,
                workersGrid,
                workerSelectedFromGrid,
                positionService,
                contractService,
                notification
        );
        dialogLayout.configure();
    }
}
