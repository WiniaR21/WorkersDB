package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
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
    // Components
    private final ServicePushNotification notification;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final EditWorkerDialogFieldsLayout fieldsLayout;
    private final EditWorkerDialog editWorkerDialog;
    //  Services
    private final WorkerPostService workerPostService;
    private final PositionGetService positionGetService;
    private final ContractPostService contractPostService;
    private final WorkerDeleteService workerDeleteService;
    private final WorkerGetService workerGetService;

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
                workerPostService,
                editWorkerDialog,
                workersGrid,
                fieldsLayout,
                workerSelectedFromGrid,
                notification,
                workerGetService
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
                notification,
                workersGrid,
                editWorkerDialog,
                workerSelectedFromGrid.getContract() != null,
                workerSelectedFromGrid,
                positionGetService,
                contractPostService
        );
        writteContractButton.configure();
    }
    private void setFireWorkerButton(){
        fireWorkerButton = new FireWorkerButton(
                notification,
                workersGrid,
                editWorkerDialog,
                workerSelectedFromGrid,
                workerDeleteService
        );
        fireWorkerButton.configure();
    }
    private void setWorkerCostsInfoButton(){
        workerCostsInfoButton = new WorkerCostsInfoButton(
                workerPostService,
                workerSelectedFromGrid,
                notification
                );
        workerCostsInfoButton.configure();
    }
}
