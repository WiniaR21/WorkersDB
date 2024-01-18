package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;

public class PeselField extends TextField {
    public PeselField() {
        this.setLabel("PESEL");
        setRequiredIndicatorVisible(true);
        setMinLength(11);
        setMaxLength(11);
        setErrorMessage("Pesel powinien zawierać 11 cyfr");

    }
}
