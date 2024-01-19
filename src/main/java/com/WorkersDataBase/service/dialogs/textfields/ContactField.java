package com.WorkersDataBase.service.dialogs.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class ContactField extends TextField implements ComponentCreator {
    String originalEmail;
    String newEmail;

    String message;

    public ContactField(String originalEmail, String newEmail) {
        this.originalEmail = originalEmail;
        this.newEmail = newEmail;

        message = createTextMessage();
        configureComponents();
        configureFront();
    }

    private String createTextMessage() {
        return originalEmail + " -> " + newEmail;
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setReadOnly(true);
        setValue(message);


    }
}
