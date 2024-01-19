package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class LastNameFieldNew extends TextField implements ComponentCreator {
    String newLastName;
    public LastNameFieldNew(String newLastName) {
        this.newLastName = newLastName;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Nazwisko");
        setReadOnly(true);
        setValue(newLastName);
    }
}
