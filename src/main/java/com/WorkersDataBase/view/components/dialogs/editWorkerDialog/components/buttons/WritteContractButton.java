package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WritteContractButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    private final EditWorkerDialog          editWorkerDialog;
    private final boolean                   workerHasContract;
    private final Worker                    worker;
    //  Services
    private final PositionGetService        positionGetService;
    private final ContractPostService contractPostService;


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
               notification,
                workersGrid,
                worker,
                workerHasContract,
                editWorkerDialog,
                positionGetService,
                contractPostService
        );
        writeContractDialog.configure();
    }
}
