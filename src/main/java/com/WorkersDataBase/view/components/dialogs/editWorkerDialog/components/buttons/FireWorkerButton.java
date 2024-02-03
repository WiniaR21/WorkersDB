package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    // Components
    private final ServicePushNotification notification;
    private final WorkersGrid workersGrid;
    private final EditWorkerDialog editWorkerDialog;
    private final Worker workerSelectedFromGrid;
    //  Services
    private final WorkerDeleteService workerDeleteService;
    @Override
    public void clickEvent() {
        editWorkerDialog.close();

        FireWorkerConfirmDialog fireWorkerConfirmDialog
                = new FireWorkerConfirmDialog(
                notification,
                workersGrid,
                editWorkerDialog,
                workerSelectedFromGrid,
                workerDeleteService
        );
        fireWorkerConfirmDialog.configure();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zwolnij");
        addThemeVariants(ButtonVariant.LUMO_ERROR);
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
