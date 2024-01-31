package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkersLastNameField extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
    }
}
