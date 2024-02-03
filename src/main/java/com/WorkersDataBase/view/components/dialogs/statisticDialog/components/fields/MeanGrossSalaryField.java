package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields;

import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeanGrossSalaryField
        extends NumberField
        implements ComponentCreator
{
    //  To inject by constructor
    private final ContractGetService contractGetService;

    //  To configure
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
        setValue(contractGetService.getAvgGrossSalary());
        setSuffixComponent(plnSuffix);
    }
}
