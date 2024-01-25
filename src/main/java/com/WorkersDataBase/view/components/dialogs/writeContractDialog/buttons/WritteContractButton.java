package com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.SalaryField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final Worker worker;
    private final SalaryField salaryField;
    private final ComboBox<Position> position;
    private final ContractService contractService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;

    @Override
    public void clickEvent() {
        boolean success = contractService.writeContractWithWorker(
                worker, getPositionFromUser(), getSalaryFromUser());

        if (success) {
            workersGrid.refresh();
            writeContractDialog.close();
            editWorkerDialog.close();
        }
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zatwierdź");
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        addClickListener(e -> clickEvent());
        addClickShortcut(Key.ENTER);
    }
    private String getPositionFromUser(){
        if (position.isEmpty()){
            throw new RuntimeException("PositionField can not be empty");
        }
        return position.getValue().getPositionName();
    }
    private double getSalaryFromUser(){
        if (salaryField.isEmpty()){
         throw new RuntimeException("SalaryField can not be empty");
        }
        return salaryField.getValue();
    }
}
