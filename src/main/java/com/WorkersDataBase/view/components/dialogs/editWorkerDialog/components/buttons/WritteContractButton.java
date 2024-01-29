package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final Worker worker;
    private final boolean workerHasContract;
    private final ContractService contractService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        editWorkerDialog.close();
        openWriteContractDialog();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        if (workerHasContract){
            setText("Zmień umowę");
        }
        else{
            setText("Podpisz umowę");
        }
        addClickListener(buttonClickEvent -> clickEvent());
    }
    private void openWriteContractDialog(){
        WriteContractDialog writeContractDialog = new WriteContractDialog(
                positionService,
                worker,
                contractService,
                workerHasContract,
                editWorkerDialog,
                workersGrid,
                notification
        );
        writeContractDialog.configure();
    }
}
