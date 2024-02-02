package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.buttons;

import com.WorkersDataBase.data.contract.worker.Worker;
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
public class ConfirmButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
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
        if (status ==  0) {
            notification.pushAddingWorkerSuccess(newWorker);
            workersGrid.refresh();
            confirmEditDialog.close();
        }
        else if (status ==  1) {
            notification.pushEditSuccess();
            workersGrid.refresh();
            confirmEditDialog.close();
        }

        else if (status == -1) notification.pushError();
        else if (status == -2) notification.pushEmptyFieldsError();
        else if (status == -3) notification.pushSpecialSymbolsError();
        else if (status == -4) notification.pushPeselLengthError();
        else if (status == -5) notification.pushPeselUniqueError();
        else if (status == -6) notification.pushEmailUniqueError();
        else if (status == -7) notification.pushFirstNameIsToShortInfo();
        else if (status == -8) notification.pushLastNameIsToShortInfo();
        else if (status == -9) notification.pushPeselControlNumberError();

    }
}
