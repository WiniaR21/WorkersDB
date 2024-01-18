package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.vaadin.flow.component.textfield.EmailField;

public class WorkersEmailField extends EmailField {
    public WorkersEmailField() {
        setLabel("Adres email");
        setErrorMessage("Podaj porawny adres email");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);
    }
}
