package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class PeselFieldNew extends TextField implements ComponentCreator {
    String newPesel;
    public PeselFieldNew( String newPesel) {
        this.newPesel = newPesel;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("PESEL");
        setReadOnly(true);
        setValue(newPesel);
    }
}
