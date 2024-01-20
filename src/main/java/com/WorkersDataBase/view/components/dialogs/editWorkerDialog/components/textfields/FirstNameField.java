package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Setter;


public class FirstNameField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String firstName;
    public FirstNameField(String firstName) {
        this.firstName = firstName;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Imie");
        setMinLength(3);
        setErrorMessage("Imie jest za krótkie");
        setValue(firstName);
    }
}
