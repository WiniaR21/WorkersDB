package com.WorkersDataBase.service.dialogs.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class PeselField extends TextField implements ComponentCreator {
    String originalPesel;
    String newPesel;
    String message;

    public PeselField(String originalPesel, String newPesel) {
        this.originalPesel = originalPesel;
        this.newPesel = newPesel;

        message = createTextMessage();
        configureComponents();
        configureFront();
    }
    private String createTextMessage() {
        return originalPesel + " -> " + newPesel;
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
