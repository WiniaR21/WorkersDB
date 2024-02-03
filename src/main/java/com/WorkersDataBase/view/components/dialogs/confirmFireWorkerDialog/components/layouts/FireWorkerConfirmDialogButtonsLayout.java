package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.buttons.ConfirmFireButton;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.buttons.CloseFireWorkerConfirmDialogButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialogButtonsLayout
        extends HorizontalLayout
        implements ComponentCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    private final FireWorkerConfirmDialog   fireWorkerConfirmDialog;
    private final EditWorkerDialog          editWorkerDialog;
    private final Worker                    workerSelectedFromGrid;
    //  Services
    private final WorkerDeleteService       workerDeleteService;

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
                notification,
                workersGrid,
                fireWorkerConfirmDialog,
                workerSelectedFromGrid,
                workerDeleteService
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
