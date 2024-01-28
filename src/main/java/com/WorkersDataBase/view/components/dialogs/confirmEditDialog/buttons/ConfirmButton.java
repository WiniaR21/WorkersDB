package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmButton extends Button implements ComponentCreator, ButtonCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        int status = workerService.addWorker(newWorker, true);
        statusResponse(status);
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Potwierdź");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ENTER);
    }
    private void statusResponse(int status){
        if (status ==  1) notification.pushEditSuccess();
        if (status ==  0) notification.pushAddingWorkerSuccess(newWorker);
        if (status == -1) notification.pushError();
        if (status == -2) notification.pushEmptyFieldsError();
        if (status == -3) notification.pushSpecialSymbolsError();
        if (status == -4) notification.pushPeselLengthError();
        if (status == -5) notification.pushPeselUniqueError();
        if (status == -6) notification.pushEmailUniqueError();
        if (status == -7) notification.pushFirstNameIsToShortInfo();
        if (status == -8) notification.pushLastNameIsToShortInfo();

        if (status == 0){
            workersGrid.refresh();
            confirmEditDialog.close();
        }
    }
}
