package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class PeselField extends TextField implements ComponentCreator {
    String originalPesel;
    String message;

    public PeselField(String originalPesel) {
        this.originalPesel = originalPesel;

        message = createTextMessage();
        configureComponents();
        configureFront();
    }
    private String createTextMessage() {
        return originalPesel + " -> ";
    }
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("PESEL");
        setReadOnly(true);
        setValue(message);
    }
}
