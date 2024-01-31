package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.EmailField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkersEmailField extends EmailField implements ComponentCreator {

    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setLabel("Adres email");
        setErrorMessage("Podaj porawny adres email");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);
    }
}
