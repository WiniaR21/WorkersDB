package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
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
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;

    public DialogLayout(
            WorkerService workerService,
            EditWorkerDialog editWorkerDialog,
            WorkersGrid workersGrid,
            Worker workerSelectedFromGrid,
            PositionService positionService
    ) {
        this.workerService = workerService;
        this.editWorkerDialog = editWorkerDialog;
        this.workersGrid = workersGrid;
        this.workerSelectedFromGrid = workerSelectedFromGrid;
        this.positionService = positionService;

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

        fieldsLayout = new FieldsLayout(workerSelectedFromGrid);

        buttonsLayout = new ButtonsLayout(
                workerService,
                workersGrid,
                editWorkerDialog,
                fieldsLayout,
                workerSelectedFromGrid,
                positionService
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
