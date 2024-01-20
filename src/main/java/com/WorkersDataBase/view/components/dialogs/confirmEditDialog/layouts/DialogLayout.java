package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;
    private final Worker oryginalWorker;

    public DialogLayout(
            WorkerService workerService,
            Worker newWorker,
            WorkersGrid workersGrid,
            ConfirmEditDialog confirmEditDialog,
            Worker oryginalWorker
    ) {
        this.workerService = workerService;
        this.newWorker = newWorker;
        this.workersGrid = workersGrid;
        this.confirmEditDialog = confirmEditDialog;
        this.oryginalWorker = oryginalWorker;

        configureComponents();
        configureFront();
    }

    //  To configure
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {

        fieldsLayout = new FieldsLayout(
                oryginalWorker,
                newWorker
        );

        buttonsLayout = new ButtonsLayout(
                workerService,
                newWorker,
                workersGrid,
                confirmEditDialog
        );
    }

    @Override
    public void configureFront() {
        add(
                fieldsLayout,
                buttonsLayout
        );
    }
}
