package com.WorkersDataBase.view.components.dialogs.workerInfoDialog;

import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {

    }
}
