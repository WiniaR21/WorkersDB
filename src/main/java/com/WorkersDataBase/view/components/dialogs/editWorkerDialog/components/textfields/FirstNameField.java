package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class FirstNameField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String firstName;

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
