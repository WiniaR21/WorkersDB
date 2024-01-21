package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;


import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.DialogLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;


@Getter
public class EditWorkerDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final PositionService positionService;
    private final ContractService contractService;

    public EditWorkerDialog(
            WorkerService workerService,
            WorkersGrid workersGrid,
            Worker workerSelectedFromGrid,
            PositionService positionService,
            ContractService contractService
    ) {
        this.workerService = workerService;
        this.workersGrid = workersGrid;
        this.workerSelectedFromGrid = workerSelectedFromGrid;
        this.positionService = positionService;
        this.contractService = contractService;

        configureComponents();
        configureFront();
    }

    //  To configure
    DialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout(
                workerService,
                this,
                workersGrid,
                workerSelectedFromGrid,
                positionService,
                contractService
        );
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }

}
