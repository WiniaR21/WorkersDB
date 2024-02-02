package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.buttons.ConfirmFireButton;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.buttons.CloseFireWorkerConfirmDialogButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final FireWorkerConfirmDialog fireWorkerConfirmDialog;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    ConfirmFireButton confirmFireButton;
    CloseFireWorkerConfirmDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setConfirmFireButton();
        setCloseDialogButton();
    }
    @Override
    public void configureFront() {
        add(
                confirmFireButton,
                closeDialogButton
        );
    }
    private void setConfirmFireButton() {
        confirmFireButton = new ConfirmFireButton(
                workerService,
                workersGrid,
                workerSelectedFromGrid,
                fireWorkerConfirmDialog,
                notification
        );
        confirmFireButton.configure();
    }
    public void setCloseDialogButton() {
        closeDialogButton = new CloseFireWorkerConfirmDialogButton(
                fireWorkerConfirmDialog,
                editWorkerDialog
        );
        closeDialogButton.configure();
    }
}
