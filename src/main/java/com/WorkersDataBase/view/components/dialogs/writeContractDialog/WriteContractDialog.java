package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts.WriteContractLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialog extends Dialog implements ComponentCreator {
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
    public void configureComponents() {
        configureWriteContractLayout();
    }
    @Override
    public void configureFront() {
        add(writeContractLayout);
        open();
    }
    private void configureWriteContractLayout(){
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
