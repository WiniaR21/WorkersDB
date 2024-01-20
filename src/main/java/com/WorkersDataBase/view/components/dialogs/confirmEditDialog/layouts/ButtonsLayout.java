package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.ConfirmButton;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons.RejectButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hibernate.jdbc.Work;

public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final Worker newWorker;
    private final WorkersGrid workersGrid;
    private final ConfirmEditDialog confirmEditDialog;

    public ButtonsLayout(
            WorkerService workerService,
            Worker newWorker,
            WorkersGrid workersGrid,
            ConfirmEditDialog confirmEditDialog
    ) {
        this.workerService = workerService;
        this.newWorker = newWorker;
        this.workersGrid = workersGrid;
        this.confirmEditDialog = confirmEditDialog;

        configureComponents();
        configureFront();
    }

    //  To configure
    ConfirmButton confirmButton;
    RejectButton rejectButton;

    @Override
    public void configureComponents() {
        confirmButton = new ConfirmButton(
                workerService,
                newWorker,
                workersGrid,
                confirmEditDialog
        );

        rejectButton = new RejectButton(confirmEditDialog);
    }

    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(confirmButton, rejectButton);
    }
}
