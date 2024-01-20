package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Setter;


public class EmailField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String email;
    public EmailField(String email) {
        this.email = email;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Adres email");
        setErrorMessage("Podaj porawny adres email");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);
        setValue(email);
    }
}
