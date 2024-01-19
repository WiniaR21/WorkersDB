package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.ConfirmButton;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.RejectButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hibernate.jdbc.Work;

public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    Worker newWorker;
    private final WorkerService workerService;
    private final ConfirmEditDialog confirmEditDialog;
    private final WorkersGrid workersGrid;

    //  To configure
    ConfirmButton confirmButton;
    RejectButton rejectButton;


    public ButtonsLayout(
            Worker newWorker,
            WorkerService workerService,
            ConfirmEditDialog confirmEditDialog,
            WorkersGrid workersGrid
    ) {
        this.newWorker = newWorker;
        this.workerService = workerService;
        this.confirmEditDialog = confirmEditDialog;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        confirmButton = new ConfirmButton(newWorker, workersGrid, workerService, confirmEditDialog);
        rejectButton = new RejectButton(confirmEditDialog);
    }

    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        add(confirmButton, rejectButton);
    }
}
