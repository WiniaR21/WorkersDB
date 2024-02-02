package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts.WriteContractDialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;
    private final boolean workerHasContract;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;

    //  To configure
    WriteContractDialogLayout dialogLayout;

    @Override
    public void configureComponents() { setDialogLayout();}
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        dialogLayout = new WriteContractDialogLayout(
                this,
                positionService,
                worker,
                contractService,
                workerHasContract,
                editWorkerDialog,
                workersGrid,
                notification
        );
        dialogLayout.configure();
    }
}
