package com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons;

import com.WorkersDataBase.data.contract.position.Position;
import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.EndContractDateField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.SalaryField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields.StartContractDateField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

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
    private final StartContractDateField startContractDateField;
    private final EndContractDateField endContractDateField;
    private final ServicePushNotification notification;
    @Override
    public void clickEvent() {
        int status = contractService.writeContractWithWorker(
                worker,
                getPositionFromUser(),
                getSalaryFromUser(),
                getStartDateFromUser(),
                getEndDateFromUser()
        );
        statusResponse(status);
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
        if (position.isEmpty()) return null;
        return position.getValue().getPositionName();
    }
    private double getSalaryFromUser(){
        if (salaryField.isEmpty()) return 0;
        return salaryField.getValue();
    }
    private LocalDate getStartDateFromUser(){
        return startContractDateField.getValue();
    }
    private LocalDate getEndDateFromUser(){
        return endContractDateField.getValue();
    }
    private void statusResponse(int status){

        if (status ==  1) notification.pushChangeContractSuccess(worker);
        if (status ==  0) notification.pushWriteContractSuccess(worker);
        if (status == -1) notification.pushPositionNameIsNull();
        if (status == -2) notification.pushNationalLowestInfo();
        if (status == -3) notification.pushStartDateError();
        if (status == -4) notification.pushEndDateError();

        if (status == 0 || status == 1) {
            workersGrid.refresh();
            writeContractDialog.close();
            editWorkerDialog.close();
        }
    }
}
