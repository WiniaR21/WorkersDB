package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class FirstNameField extends TextField implements ComponentCreator {
    String originalFirstName;
    String message;

    public FirstNameField(String originalFirstName) {
        this.originalFirstName = originalFirstName;
        message = createTextMessage();

        configureComponents();
        configureFront();
    }
    private String createTextMessage() {
        return originalFirstName + " -> ";
    }
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Imie");
        setReadOnly(true);
        setValue(message);
    }
}
