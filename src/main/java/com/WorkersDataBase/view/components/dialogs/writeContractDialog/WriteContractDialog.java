package com.WorkersDataBase.view.components.dialogs.writeContractDialog;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts.WriteContractLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class WriteContractDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    Worker worker;

    public WriteContractDialog(PositionService positionService, Worker worker) {
        this.positionService = positionService;
        this.worker = worker;

        configureComponents();
        configureFront();

        //  TODO logika podpisywania kontraktu
    }

    //  To configure
    WriteContractLayout writeContractLayout;

    @Override
    public void configureComponents() {
        writeContractLayout = new WriteContractLayout(
                this,
                positionService,
                worker
        );
    }

    @Override
    public void configureFront() {
        add(writeContractLayout);
        open();
    }
}
