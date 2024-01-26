package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.layouts.FireWorkerConfirmDialogLayout;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;

    //  To configure
    FireWorkerConfirmDialogLayout fireWorkerConfirmDialogLayout;
    @Override
    public void configureComponents() {
        fireWorkerConfirmDialogLayout = new FireWorkerConfirmDialogLayout(
                workerService,
                workersGrid,
                workerSelectedFromGrid,
                this,
                editWorkerDialog
        );
        fireWorkerConfirmDialogLayout.configure();
    }

    @Override
    public void configureFront() {
        add(fireWorkerConfirmDialogLayout);
        open();

    }
}
