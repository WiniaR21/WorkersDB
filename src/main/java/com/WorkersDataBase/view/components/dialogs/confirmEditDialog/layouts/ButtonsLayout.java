package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.ConfirmButton;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.RejectButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    ConfirmButton confirmButton;
    RejectButton rejectButton;

    @Override
    public void configureComponents() {
        confirmButton = new ConfirmButton(
                workerService,
                newWorker,
                workersGrid,
                confirmEditDialog,
                notification
        );
        confirmButton.configure();

        rejectButton = new RejectButton(confirmEditDialog, editWorkerDialog);
        rejectButton.configure();
    }
    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(confirmButton, rejectButton);
    }
}
