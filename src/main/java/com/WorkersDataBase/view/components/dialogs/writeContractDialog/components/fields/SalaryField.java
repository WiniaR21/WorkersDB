package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalaryField extends NumberField implements ComponentCreator {
    //  To configure
    Div zlSuffix;

    @Override
    public void configureComponents() {
        zlSuffix = new Div();
        zlSuffix.setText("PLN");
    }
    @Override
    public void configureFront() {
        setLabel("Wynagrodzenie brutto");
        setSuffixComponent(zlSuffix);
    }
}
