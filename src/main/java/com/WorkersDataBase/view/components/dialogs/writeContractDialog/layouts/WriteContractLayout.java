package com.WorkersDataBase.view.components.dialogs.writeContractDialog.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
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
    Worker worker;

    public WriteContractLayout(
            WriteContractDialog writeContractDialog,
            PositionService positionService,
            Worker worker
    ) {
        this.writeContractDialog = writeContractDialog;
        this.positionService = positionService;
        this.worker = worker;

        configureComponents();
        configureFront();
    }
    //   To configure
    ComboBox<Position> positions;
    SalaryField salaryField;
    CloseWriteContract closeWriteContract;
    WritteContractButton writteContractButton;

    @Override
    public void configureComponents() {
        positions = new ComboBox<>("Wybierz stanowisko");
        positions.setItems(positionService.getPositions());
        positions.setItemLabelGenerator(Position::getPositionName);

        salaryField = new SalaryField();

        writteContractButton = new WritteContractButton(writeContractDialog);

        closeWriteContract = new CloseWriteContract(writeContractDialog);
    }

    @Override
    public void configureFront() {
            add(
                    positions,
                    salaryField,
                    new HorizontalLayout(writteContractButton, closeWriteContract)
            );
    }
}
