package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;


public class LastNameField extends TextField {
    String lastName;
    public LastNameField() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setValue(lastName);
    }
}
