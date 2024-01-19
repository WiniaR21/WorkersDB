package com.WorkersDataBase.service.dialogs.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class FirstNameField extends TextField implements ComponentCreator {
    String originalFirstName;
    String newFirstName;
    String message;

    public FirstNameField(String originalFirstName, String newFirstName) {
        this.originalFirstName = originalFirstName;
        this.newFirstName = newFirstName;

        message = createTextMessage();
        configureComponents();
        configureFront();
    }
    private String createTextMessage() {
        return originalFirstName + " -> " + newFirstName;
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
