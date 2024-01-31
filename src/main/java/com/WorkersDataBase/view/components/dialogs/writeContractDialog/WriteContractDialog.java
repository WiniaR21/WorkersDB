package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts.WriteContractLayout;
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
    WriteContractLayout writeContractLayout;

    @Override
    public void configureComponents() { setDialogLayout();}
    @Override
    public void configureFront() {
        add(writeContractLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        writeContractLayout = new WriteContractLayout(
                this,
                positionService,
                worker,
                contractService,
                workerHasContract,
                editWorkerDialog,
                workersGrid,
                notification
        );
        writeContractLayout.configure();
    }
}
