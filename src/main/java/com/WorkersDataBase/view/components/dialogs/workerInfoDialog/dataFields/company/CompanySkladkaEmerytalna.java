package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.company;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class CompanySkladkaEmerytalna extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setReadOnly(true);
    }
}
