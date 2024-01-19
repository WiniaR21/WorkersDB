package com.WorkersDataBase.service.dialogs;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.dialogs.layouts.DialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class ConfirmEditDialog extends Dialog implements ComponentCreator {
    Worker oryginalWorker;
    Worker newWorker;
    DialogLayout dialogLayout;

    public ConfirmEditDialog(Worker oryginalWorker, Worker newWorker) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(
                oryginalWorker,
                newWorker
        );
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
}
