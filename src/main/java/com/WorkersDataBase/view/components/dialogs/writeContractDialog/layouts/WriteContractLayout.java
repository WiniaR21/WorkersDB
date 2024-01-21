package com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons.CloseWriteContract;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons.WritteContractButton;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.SalaryField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WriteContractLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;
    private final boolean workerHasContract;

    public WriteContractLayout(
            WriteContractDialog writeContractDialog,
            PositionService positionService,
            Worker worker,
            ContractService contractService,
            boolean workerHasContract
    ) {
        this.writeContractDialog = writeContractDialog;
        this.positionService = positionService;
        this.worker = worker;
        this.contractService = contractService;
        this.workerHasContract = workerHasContract;

        configureComponents();
        configureFront();
    }
    //   To configure
    ComboBox<Position> position;
    SalaryField salaryField;
    CloseWriteContract closeWriteContract;
    WritteContractButton writteContractButton;

    @Override
    public void configureComponents() {
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
                workerHasContract
        );

        closeWriteContract = new CloseWriteContract(writeContractDialog);
    }

    @Override
    public void configureFront() {
            add(
                    position,
                    salaryField,
                    new HorizontalLayout(writteContractButton, closeWriteContract)
            );
    }
}
