package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.company;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class CompanySkladkaRentowa extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setReadOnly(true);
    }
}
