package com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons.CloseWriteContract;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons.WritteContractButton;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.SalaryField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WriteContractLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;
    private final boolean workerHasContract;
    private final EditWorkerDialog editWorkerDialog;


    public WriteContractLayout(
            WriteContractDialog writeContractDialog,
            PositionService positionService,
            Worker worker,
            ContractService contractService,
            boolean workerHasContract,
            EditWorkerDialog editWorkerDialog
    ) {
        this.writeContractDialog = writeContractDialog;
        this.positionService = positionService;
        this.worker = worker;
        this.contractService = contractService;
        this.workerHasContract = workerHasContract;
        this.editWorkerDialog = editWorkerDialog;

        configureComponents();
        configureFront();
    }
    //   To configure
    ComboBox<Position> position;
    SalaryField salaryField;
    CloseWriteContract closeWriteContract;
    WritteContractButton writteContractButton;
    H3 header;

    @Override
    public void configureComponents() {

        if(workerHasContract) header = new H3("Zmień umowę");
        else header = new H3("Podpisz nową umowę");

        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");



        position = new ComboBox<>("Wybierz stanowisko");
        position.setItems(positionService.getPositions());
        position.setItemLabelGenerator(Position::getPositionName);

        salaryField = new SalaryField();

        writteContractButton = new WritteContractButton(
                writeContractDialog,
                worker,
                salaryField,
                position,
                contractService,
                workerHasContract,
                editWorkerDialog
        );

        closeWriteContract = new CloseWriteContract(
                writeContractDialog, editWorkerDialog);
    }

    @Override
    public void configureFront() {
            add(
                    header,
                    position,
                    salaryField,
                    new HorizontalLayout(writteContractButton, closeWriteContract)
            );
    }
}
