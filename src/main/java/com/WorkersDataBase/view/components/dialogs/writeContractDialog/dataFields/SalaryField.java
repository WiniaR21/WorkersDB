package com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;


public class SalaryField extends NumberField implements ComponentCreator {
    public SalaryField() {
        configureComponents();
        configureFront();
    }
    //  To configure
    Div zlSuffix;
    @Override
    public void configureComponents() {
        zlSuffix = new Div();
        zlSuffix.setText("ZŁ");
    }

    @Override
    public void configureFront() {
        setLabel("Wynagrodzenie brutto");
        setSuffixComponent(zlSuffix);
    }
}
