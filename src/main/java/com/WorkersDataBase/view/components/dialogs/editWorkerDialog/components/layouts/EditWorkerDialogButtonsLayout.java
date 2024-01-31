package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.*;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EditWorkerDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final EditWorkerDialogFieldsLayout fieldsLayout;
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;
    private final ContractService contractService;
    private final ServicePushNotification notification;

    // To configure
    SaveChangesButton saveChangesButton;
    CloseEditWorkerDialogButton closeDialogButton;
    FireWorkerButton fireWorkerButton;
    WritteContractButton writteContractButton;
    WorkerCostsInfoButton workerCostsInfoButton;

    @Override
    public void configureComponents() {
        setSaveChangesButton();
        setCloseDialogButton();
        setFireWorkerButton();
        setWriteContractButton();
        setWorkerCostsInfoButton();
    }
    @Override
    public void configureFront() {
        add(
                saveChangesButton,
                closeDialogButton,
                fireWorkerButton,
                writteContractButton,
                workerCostsInfoButton
        );
    }
    private void setSaveChangesButton(){
        saveChangesButton = new SaveChangesButton(
                workerService,
                editWorkerDialog,
                workersGrid,
                fieldsLayout,
                workerSelectedFromGrid,
                notification
        );

        saveChangesButton.configure();
    }
    private void setCloseDialogButton(){
        closeDialogButton = new CloseEditWorkerDialogButton(
                editWorkerDialog
        );

        closeDialogButton.configure();
    }
    private void setWriteContractButton(){
        writteContractButton = new WritteContractButton(
                positionService,
                workerSelectedFromGrid,
                workerSelectedFromGrid.getContract() != null,
                contractService,
                editWorkerDialog,
                workersGrid,
                notification
        );
        writteContractButton.configure();
    }
    private void setFireWorkerButton(){
        fireWorkerButton = new FireWorkerButton(
                workerService,
                editWorkerDialog,
                workersGrid,
                workerSelectedFromGrid,
                notification
        );
        fireWorkerButton.configure();
    }
    private void setWorkerCostsInfoButton(){
        workerCostsInfoButton = new WorkerCostsInfoButton(
                workerService,
                workerSelectedFromGrid,
                notification
                );
        workerCostsInfoButton.configure();
    }
}
