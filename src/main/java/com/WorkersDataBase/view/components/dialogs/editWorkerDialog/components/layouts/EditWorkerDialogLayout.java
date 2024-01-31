package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditWorkerDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;
    private final ContractService contractService;
    private final ServicePushNotification notification;

    //  To configure
    H3 header;
    EditWorkerDialogFieldsLayout fieldsLayout;
    EditWorkerDialogButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);

        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }
    private void configureHeader(){
        header = new H3("Edytuj dane pracownika");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void configureFieldsLayout() {
        fieldsLayout = new EditWorkerDialogFieldsLayout(workerSelectedFromGrid);
        fieldsLayout.configure();
    }
    private void configureButtonsLayout(){
        buttonsLayout = new EditWorkerDialogButtonsLayout(
                workerService,
                editWorkerDialog,
                workersGrid,
                fieldsLayout,
                workerSelectedFromGrid,
                positionService,
                contractService,
                notification
        );

        buttonsLayout.configure();
    }
}
