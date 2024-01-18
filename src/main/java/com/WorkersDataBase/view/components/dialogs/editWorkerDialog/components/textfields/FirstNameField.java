package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;


public class FirstNameField extends TextField {
    public FirstNameField() {
        setLabel("Imie");
        setMinLength(3);
        setErrorMessage("Imie jest za krótkie");
    }
}
