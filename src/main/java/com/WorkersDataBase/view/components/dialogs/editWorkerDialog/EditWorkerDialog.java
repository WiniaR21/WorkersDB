package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;


import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.DialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;

@Getter
public class EditWorkerDialog extends Dialog implements ComponentCreator {

    //  To inject by constructor
    private final WorkerService workerService;

    //  To configure
    DialogLayout dialogLayout;
    public EditWorkerDialog(WorkerService workerService) {
        this.workerService = workerService;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(workerService, this);
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
    }

}
