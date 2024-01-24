package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LastNameField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String lastName;

    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
        setValue(lastName);
    }
}
