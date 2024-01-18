package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.vaadin.flow.component.textfield.TextField;

public class WorkersLastNameField extends TextField {
    public WorkersLastNameField() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
    }
}
