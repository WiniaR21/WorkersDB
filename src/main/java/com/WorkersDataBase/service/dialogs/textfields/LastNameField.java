package com.WorkersDataBase.service.dialogs.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;


public class LastNameField extends TextField implements ComponentCreator {
    String originalLastName;
    String newLastName;
    String message;

    public LastNameField(String originalLastName, String newLastName) {
        this.originalLastName = originalLastName;
        this.newLastName = newLastName;

        message = createTextMessage();
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }
    private String createTextMessage() {
        return originalLastName + " -> " + newLastName;
    }
    @Override
    public void configureFront() {
        setReadOnly(true);
        setValue(message);
    }
}
