package com.WorkersDataBase.view.components.dialogs.confirmEditDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts.DialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class ConfirmEditDialog extends Dialog implements ComponentCreator {

    //  To inject by constructor
    private final Worker oryginalWorker;
    private final Worker newWorker;
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    //  To configure
    DialogLayout dialogLayout;

    public ConfirmEditDialog(Worker oryginalWorker, Worker newWorker, WorkerService workerService, WorkersGrid workersGrid) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;
        this.workerService = workerService;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(
                workerService,
                this,
                oryginalWorker,
                newWorker,
                workersGrid
        );
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
}
