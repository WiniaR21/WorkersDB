package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.EndContractDateField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.SalaryField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.StartContractDateField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialogFieldsLayout
        extends VerticalLayout
        implements ComponentCreator
{
    //  Services
    private final PositionGetService    positionGetService;

    //  To configure
                    ComboBox<Position>  position;
                    SalaryField         salaryField;
                StartContractDateField  startContractDateField;
                EndContractDateField    endContractDateField;
    @Override
    public void configureComponents() {
        setPosition();
        setSalaryField();
        setStartContractDateField();
        setEndContractDateField();
    }
    @Override
    public void configureFront() {
        add(
                position,
                salaryField,
                startContractDateField,
                endContractDateField
        );
    }
    private void setPosition() {
        position = new ComboBox<>("Wybierz stanowisko");
        position.setItems(positionGetService.getPositions());
        position.setItemLabelGenerator(Position::getPositionName);
    }
    private void setSalaryField() {
        salaryField = new SalaryField();
        salaryField.configure();
    }
    private void setStartContractDateField() {
        startContractDateField = new StartContractDateField();
        startContractDateField.configure();
    }
    private void setEndContractDateField() {
        endContractDateField = new EndContractDateField();
        endContractDateField.configure();
    }
}
