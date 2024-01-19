package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;
import lombok.Setter;


public class FirstNameField extends TextField {
    String firstName;
    public FirstNameField() {
        setLabel("Imie");
        setMinLength(3);
        setErrorMessage("Imie jest za krótkie");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setValue(firstName);
    }
}
