package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalaryField extends NumberField implements ComponentCreator {
    //  To configure
    Div plnSuffix;

    @Override
    public void configureComponents() {
        plnSuffix = new Div();
        plnSuffix.setText("PLN");
    }
    @Override
    public void configureFront() {
        setLabel("Wynagrodzenie brutto");
        setSuffixComponent(plnSuffix);
    }
}
