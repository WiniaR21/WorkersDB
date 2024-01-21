package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class WorkersPeselField  extends TextField implements ComponentCreator {
    public WorkersPeselField() {
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
    }
}
