package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;


import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.DialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;

@Getter
public class EditWorkerDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    Worker workerSelectedFromGrid;
    public EditWorkerDialog(
            WorkerService workerService,
            WorkersGrid workersGrid,
            Worker workerSelectedFromGrid
    ) {
        this.workerService = workerService;
        this.workersGrid = workersGrid;
        this.workerSelectedFromGrid = workerSelectedFromGrid;

        configureComponents();
        configureFront();
    }

    //  To configure
    DialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(
                workerService,
                this,
                workersGrid,
                workerSelectedFromGrid
        );
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }

}
