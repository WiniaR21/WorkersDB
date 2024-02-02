package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeanGrossSalaryField extends NumberField implements ComponentCreator {
    private final ContractService contractService;
    Div plnSuffix;
    @Override
    public void configureComponents() {
        plnSuffix = new Div();
        plnSuffix.setText("PLN");
    }

    @Override
    public void configureFront() {
        setLabel("Śr. wynagrodzenie brutto");
        setReadOnly(true);
        setValue(contractService.getAvgGrossSalary());
        setSuffixComponent(plnSuffix);
    }
}
