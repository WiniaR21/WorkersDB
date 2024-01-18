package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;

public class EmailField extends TextField {
    public EmailField() {
        setLabel("Adres email");
        setErrorMessage("Podaj porawny adres email");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);

    }
}
