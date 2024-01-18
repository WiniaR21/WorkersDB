package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;

public class LastNameField extends TextField {
    public LastNameField() {
        setLabel("Nazwisko");
        setMinLength(3);
        setErrorMessage("Nazwisko jest za krótkie");
    }
}
