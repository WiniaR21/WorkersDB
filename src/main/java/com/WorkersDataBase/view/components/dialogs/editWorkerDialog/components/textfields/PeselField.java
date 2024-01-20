package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;


public class PeselField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String pesel;
    public PeselField(String pesel) {
        this.pesel = pesel;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("PESEL");
        setRequiredIndicatorVisible(true);
        setMinLength(11);
        setMaxLength(11);
        setErrorMessage("Pesel powinien zawierać 11 cyfr");
        setValue(pesel);
    }
}
