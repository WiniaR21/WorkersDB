package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.vaadin.flow.component.textfield.TextField;


public class PeselField extends TextField {
    String pesel;
    public PeselField() {
        this.setLabel("PESEL");
        setRequiredIndicatorVisible(true);
        setMinLength(11);
        setMaxLength(11);
        setErrorMessage("Pesel powinien zawierać 11 cyfr");
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
        setValue(pesel);
    }
}
