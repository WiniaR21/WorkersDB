package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditWorkerDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  Components
    private final ServicePushNotification notification;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    //  Services
    private final PositionGetService positionGetService;
    private final WorkerPostService workerPostService;
    private final ContractPostService contractPostService;
    private final WorkerDeleteService workerDeleteService;
    private final WorkerGetService workerGetService;

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
    @Override
    public void configureHeader(){
        header = new H3("Edytuj dane pracownika");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new EditWorkerDialogFieldsLayout(workerSelectedFromGrid);
        fieldsLayout.configure();
    }
    @Override
    public void configureButtonsLayout(){
        buttonsLayout = new EditWorkerDialogButtonsLayout(
              notification,
                workersGrid,
                workerSelectedFromGrid,
                fieldsLayout,
                editWorkerDialog,
                workerPostService,
                positionGetService,
                contractPostService,
                workerDeleteService,
                workerGetService
        );
        buttonsLayout.configure();
    }
}
