package com.WorkersDataBase.view.components.dialogs.workerInfoDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.layouts.WorkerInfoDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final Worker workerSelectedFromGrid;

    //  To configure
    WorkerInfoDialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        setDialogLayout();
    }
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout( ) {
        dialogLayout = new WorkerInfoDialogLayout(
                this,
                workerSelectedFromGrid
        );
        dialogLayout.configure();
    }
}
