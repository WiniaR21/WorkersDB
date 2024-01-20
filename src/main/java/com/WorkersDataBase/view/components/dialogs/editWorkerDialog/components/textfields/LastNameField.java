package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;


public class LastNameField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String lastName;
    public LastNameField(String lastName) {
        this.lastName = lastName;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
        setValue(lastName);
    }
}
