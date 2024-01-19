package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout implements ComponentCreator {

    //  To configure
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    //  To inject by constructor
    private final WorkerService workerService;
    private final ConfirmEditDialog confirmEditDialog;
    private final Worker oryginalWorker;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;

    public DialogLayout(
            WorkerService workerService, ConfirmEditDialog confirmEditDialog, Worker oryginalWorker,
            Worker newWorker, WorkersGrid workersGrid
    ) {
        this.workerService = workerService;
        this.confirmEditDialog = confirmEditDialog;
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

        fieldsLayout = new FieldsLayout(
                oryginalWorker,
                newWorker
        );

        buttonsLayout = new ButtonsLayout(newWorker, workerService, confirmEditDialog, workersGrid);
    }

    @Override
    public void configureFront() {
        add(
                fieldsLayout,
                buttonsLayout
        );
    }
}
