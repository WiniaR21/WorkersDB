package com.WorkersDataBase.service.dialogs.textfields;

import com.vaadin.flow.component.textfield.TextField;

public class FirstNameField extends TextField {
    String originalFirstName;
    String newFirstName;

    public FirstNameField(String originalFirstName, String newFirstName) {
        this.originalFirstName = originalFirstName;
        this.newFirstName = newFirstName;
    }
}
