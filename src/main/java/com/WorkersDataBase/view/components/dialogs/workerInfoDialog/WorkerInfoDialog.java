package com.WorkersDataBase.view.components.dialogs.workerInfoDialog;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.layouts.WorkerInfoDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final Worker workerSelectedFromGrid;

    //  To configure
    WorkerInfoDialogLayout workerInfoDialogLayout;
    @Override
    public void configureComponents() {
        setWorkerInfoDialog();
    }

    @Override
    public void configureFront() {
        add(workerInfoDialogLayout);
        open();
    }

    private void setWorkerInfoDialog( ) {
        workerInfoDialogLayout = new WorkerInfoDialogLayout(this, workerSelectedFromGrid);
        workerInfoDialogLayout.configure();
    }
}
