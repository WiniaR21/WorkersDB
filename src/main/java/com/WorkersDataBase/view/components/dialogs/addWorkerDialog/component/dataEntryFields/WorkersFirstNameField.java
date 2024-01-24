package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkersFirstNameField extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setLabel("Imie");
        setMinLength(3);
        setErrorMessage("Imie jest za krótkie");
    }
}
