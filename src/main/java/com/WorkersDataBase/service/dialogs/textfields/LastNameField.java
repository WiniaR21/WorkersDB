package com.WorkersDataBase.service.dialogs.textfields;

import com.vaadin.flow.component.textfield.TextField;


public class LastNameField extends TextField {
    String originalLastName;
    String newLastName;

    public LastNameField(String originalLastName, String newLastName) {
        this.originalLastName = originalLastName;
        this.newLastName = newLastName;
    }
}
