package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;


public class LastNameField extends TextField implements ComponentCreator {
    String originalLastName;
    String message;

    public LastNameField(String originalLastName) {
        this.originalLastName = originalLastName;
        message = createTextMessage();

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }
    private String createTextMessage() {
        return originalLastName + " -> ";
    }
    @Override
    public void configureFront() {
        setLabel("Nazwisko");
        setReadOnly(true);
        setValue(message);
    }
}
