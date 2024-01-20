package com.WorkersDataBase.view.components.dialogs.confirmEditDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts.DialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class ConfirmEditDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final Worker oryginalWorker;

    public ConfirmEditDialog(
            WorkerService workerService,
            Worker newWorker,
            WorkersGrid workersGrid,
            Worker oryginalWorker
    ) {
        this.workerService = workerService;
        this.newWorker = newWorker;
        this.workersGrid = workersGrid;
        this.oryginalWorker = oryginalWorker;

        configureComponents();
        configureFront();
    }

    //  To configure
    DialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(
                workerService,
                newWorker,
                workersGrid,
                this,
                oryginalWorker
        );
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
}
