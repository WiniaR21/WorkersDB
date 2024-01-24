package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class EmailField extends TextField implements ComponentCreator {

    //  To inject by constructor
    private final String email;

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
