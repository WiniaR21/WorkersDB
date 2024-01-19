package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class ContactFieldNew extends TextField implements ComponentCreator {
    String newEmail;
    public ContactFieldNew(String newEmail) {
        this.newEmail = newEmail;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Adres email");
        setReadOnly(true);
        setValue(newEmail);
    }
}
