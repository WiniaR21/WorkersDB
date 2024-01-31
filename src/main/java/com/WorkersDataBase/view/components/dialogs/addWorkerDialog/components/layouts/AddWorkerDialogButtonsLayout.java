package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.buttons.CloseAddWorkerDialogButton;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.buttons.SaveWorkerButton;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersPeselField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddWorkerDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;
    private final WorkersFirstNameField firstNameField;
    private final WorkersLastNameField lastNameField;
    private final WorkersEmailField emailField;
    private final WorkersPeselField peselField;
    private final ServicePushNotification notification;

    //  To configure
    SaveWorkerButton saveWorkerButton;
    CloseAddWorkerDialogButton closeDialogButton;

    @Override
    public void configureComponents() {
        setSaveWorkerButton();
        setCloseDialogButton();
    }
    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(
                saveWorkerButton,
                closeDialogButton
        );
    }
    private void setSaveWorkerButton() {
        saveWorkerButton = new SaveWorkerButton(
                workerService,
                workersGrid,
                addWorkerDialog,
                firstNameField,
                lastNameField,
                emailField,
                peselField,
                notification
        );
        saveWorkerButton.configure();
    }
    private void setCloseDialogButton() {
        closeDialogButton = new CloseAddWorkerDialogButton(
                addWorkerDialog
        );
        closeDialogButton.configure();
    }
}
