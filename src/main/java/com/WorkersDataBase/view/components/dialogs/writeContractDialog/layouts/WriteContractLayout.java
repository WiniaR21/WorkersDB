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
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;
    private final boolean workerHasContract;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;

    //   To configure
    H3 header;
    ComboBox<Position> position;
    SalaryField salaryField;
    WritteContractButton writteContractButton;
    CloseWriteContract closeWriteContract;

    @Override
    public void configureComponents() {
        configureHeader();
        configurePosition();
        configureSalaryField();
        configureWriteContractButton();
        configureCloseWriteContract();
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
    private void configureHeader(){
        if(workerHasContract) header = new H3("Zmień umowę");
        else header = new H3("Podpisz nową umowę");

        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void configurePosition(){
        position = new ComboBox<>("Wybierz stanowisko");
        position.setItems(positionService.getPositions());
        position.setItemLabelGenerator(Position::getPositionName);
    }
    private void configureSalaryField(){
        salaryField = new SalaryField();
        salaryField.configure();
    }
    private void configureWriteContractButton(){
        writteContractButton = new WritteContractButton(
                writeContractDialog,
                worker,
                salaryField,
                position,
                contractService,
                editWorkerDialog,
                workersGrid

        );
        writteContractButton.configure();
    }
    private void configureCloseWriteContract(){
        closeWriteContract = new CloseWriteContract(
                writeContractDialog, editWorkerDialog);
        closeWriteContract.configure();
    }
}
