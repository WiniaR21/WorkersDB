package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.vaadin.flow.component.textfield.TextField;


public class WorkersFirstNameField extends TextField {
    public WorkersFirstNameField() {
        setLabel("Imie");
        setMinLength(3);
        setErrorMessage("Imie jest za krótkie");
    }
}
