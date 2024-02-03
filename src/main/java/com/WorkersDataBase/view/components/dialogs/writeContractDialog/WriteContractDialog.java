package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts.WriteContractDialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    private final Worker                    worker;
    private final boolean                   workerHasContract;
    private final EditWorkerDialog          editWorkerDialog;
    private final PositionGetService        positionGetService;
    private final ContractPostService contractPostService;

    //  To configure
    WriteContractDialogLayout dialogLayout;

    @Override
    public void configureComponents() {setDialogLayout();}
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        dialogLayout = new WriteContractDialogLayout(
                notification,
                workersGrid,
                worker,
                workerHasContract,
                editWorkerDialog,
                this,
                positionGetService,
                contractPostService
        );
        dialogLayout.configure();
    }
}
