package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts.WriteContractLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class WriteContractDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;

    public WriteContractDialog(
            PositionService positionService,
            Worker worker,
            ContractService contractService
    ) {
        this.positionService = positionService;
        this.worker = worker;
        this.contractService = contractService;

        configureComponents();
        configureFront();
    }

    //  To configure
    WriteContractLayout writeContractLayout;

    @Override
    public void configureComponents() {
        writeContractLayout = new WriteContractLayout(
                this,
                positionService,
                worker,
                contractService
        );
    }

    @Override
    public void configureFront() {
        add(writeContractLayout);
        open();
    }
}
