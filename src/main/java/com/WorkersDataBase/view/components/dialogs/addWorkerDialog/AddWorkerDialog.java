package com.WorkersDataBase.view.components.dialogs.addWorkerDialog;

import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts.AddWorkerDialogLayout;
import com.WorkersDataBase.service.worker.WorkerService;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddWorkerDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;

    public AddWorkerDialog(WorkerService workerService, WorkersGrid workersGrid) {
        this.workerService = workerService;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    // To configure
    AddWorkerDialogLayout addWorkerDialogLayout;

    @Override
    public void configureComponents(){

        addWorkerDialogLayout = new AddWorkerDialogLayout(
                workerService, workersGrid, this
        );
    }
    @Override
    public void configureFront(){
        setModal(true);
        add(addWorkerDialogLayout);
    }
}
