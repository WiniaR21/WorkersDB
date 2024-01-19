package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;
import lombok.Setter;


public class EmailField extends TextField {
    String email;
    public EmailField() {
        setLabel("Adres email");
        setErrorMessage("Podaj porawny adres email");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);

    }

    public void setEmail(String email) {
        this.email = email;
        setValue(email);
    }
}
