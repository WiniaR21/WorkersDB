package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class FirstNameFieldNew extends TextField implements ComponentCreator {
    String newFirstName;
    public FirstNameFieldNew(String newFirstName) {
        this.newFirstName = newFirstName;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Imie");
        setReadOnly(true);
        setValue(newFirstName);
    }
}
