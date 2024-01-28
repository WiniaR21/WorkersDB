package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;
    private final Worker oryginalWorker;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        add(
                fieldsLayout,
                buttonsLayout
        );
    }
    private void configureFieldsLayout(){
        fieldsLayout = new FieldsLayout(
                oryginalWorker,
                newWorker
        );
        fieldsLayout.configure();
    }
    private void configureButtonsLayout(){
        buttonsLayout = new ButtonsLayout(
                workerService,
                newWorker,
                workersGrid,
                confirmEditDialog,
                editWorkerDialog,
                notification
        );
        buttonsLayout.configure();
    }
}
