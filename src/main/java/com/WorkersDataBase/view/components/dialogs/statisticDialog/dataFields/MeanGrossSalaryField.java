package com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class MeanGrossSalaryField extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Śr. wynagrodzenie brutto");
        setReadOnly(true);
    }
}
