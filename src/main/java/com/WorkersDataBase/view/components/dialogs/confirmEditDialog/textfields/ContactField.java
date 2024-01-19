package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class ContactField extends TextField implements ComponentCreator {
    String originalEmail;

    String message;

    public ContactField(String originalEmail) {
        this.originalEmail = originalEmail;
        message = createTextMessage();

        configureComponents();
        configureFront();
    }

    private String createTextMessage() {
        return originalEmail + " -> ";
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Adres email");
        setReadOnly(true);
        setValue(message);
    }
}
