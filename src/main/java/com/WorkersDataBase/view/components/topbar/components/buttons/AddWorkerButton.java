package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddWorkerButton extends Button implements ComponentCreator, ButtonCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        openAddWorkerDialog();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Dodaj pracownka");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
    private void openAddWorkerDialog(){
        AddWorkerDialog addWorkerDialog = new AddWorkerDialog(
                workerService,
                workersGrid,
                notification
        );
        addWorkerDialog.configure();
    }
}
