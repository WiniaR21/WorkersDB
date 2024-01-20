package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.EditHeader;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class DialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final Worker workerOriginal;

    public DialogLayout(
            WorkerService workerService,
            EditWorkerDialog editWorkerDialog,
            WorkersGrid workersGrid,
            Worker workerOriginal
    ) {
        this.workerService = workerService;
        this.editWorkerDialog = editWorkerDialog;
        this.workersGrid = workersGrid;
        this.workerOriginal = workerOriginal;

        configureComponents();
        configureFront();
    }

    //  To configure
    EditHeader editHeader;
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        editHeader = new EditHeader();

        fieldsLayout = new FieldsLayout(workerOriginal);

        buttonsLayout = new ButtonsLayout(
                workerService,
                workersGrid,
                editWorkerDialog
        );
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        add(
                editHeader,
                fieldsLayout,
                buttonsLayout
        );
    }
}
