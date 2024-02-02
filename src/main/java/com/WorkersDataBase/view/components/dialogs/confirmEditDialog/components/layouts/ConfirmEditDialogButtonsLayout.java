package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.buttons.CloseConfirmEditDialogButton;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.buttons.ConfirmButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmEditDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    ConfirmButton confirmButton;
    CloseConfirmEditDialogButton closeDialogButton;

    @Override
    public void configureComponents() {
        setConfirmButton();
        setCloseDialogButton();
    }
    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(confirmButton, closeDialogButton);
    }
    private void setConfirmButton() {
        confirmButton = new ConfirmButton(
                workerService,
                newWorker,
                workersGrid,
                confirmEditDialog,
                notification
        );
        confirmButton.configure();
    }
    private void setCloseDialogButton() {
        closeDialogButton = new CloseConfirmEditDialogButton(
                confirmEditDialog,
                editWorkerDialog
        );
        closeDialogButton.configure();
    }
}
