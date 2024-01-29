package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.CancelChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.FireWorkerButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.SaveChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.WritteContractButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final FieldsLayout fieldsLayout;
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;
    private final ContractService contractService;
    private final ServicePushNotification notification;

    // To configure
    SaveChangesButton saveChangesButton;
    CancelChangesButton cancelChangesButton;
    FireWorkerButton fireWorkerButton;
    WritteContractButton writteContractButton;

    @Override
    public void configureComponents() {
        configureSaveChangesButton();
        configureCancelChangesButton();
        configureFireWorkerButton();
        configureWriteContractButton();
    }
    @Override
    public void configureFront() {
        add(
                saveChangesButton,
                cancelChangesButton,
                fireWorkerButton,
                writteContractButton
        );
    }
    private void configureSaveChangesButton(){
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
    private void configureCancelChangesButton(){
        cancelChangesButton = new CancelChangesButton(
                editWorkerDialog
        );

        cancelChangesButton.configure();
    }
    private void configureWriteContractButton(){
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
    private void configureFireWorkerButton(){
        fireWorkerButton = new FireWorkerButton(
                workerService,
                editWorkerDialog,
                workersGrid,
                workerSelectedFromGrid,
                notification
        );
        fireWorkerButton.configure();
    }
}
