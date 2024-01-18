package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.vaadin.flow.component.textfield.TextField;

public class WorkersPeselField  extends TextField {
    public WorkersPeselField() {
        this.setLabel("PESEL");
        setRequiredIndicatorVisible(true);
        setMinLength(11);
        setMaxLength(11);
        setErrorMessage("Pesel powinien zawierać 11 cyfr");

    }
}
