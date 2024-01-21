package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    private final PositionService positionService;
    private final Worker worker;
    private final boolean workerHasContract;
    private final ContractService contractService;
    public WritteContractButton(
            PositionService positionService,
            Worker worker,
            boolean workerHasContract,
            ContractService contractService
    ) {
        this.positionService = positionService;
        this.worker = worker;
        this.workerHasContract = workerHasContract;
        this.contractService = contractService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        new WriteContractDialog(positionService, worker, contractService);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        if (workerHasContract){
            setText("Zmień umowę");
        }
        else{
            setText("Podpisz umowę");
        }
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
