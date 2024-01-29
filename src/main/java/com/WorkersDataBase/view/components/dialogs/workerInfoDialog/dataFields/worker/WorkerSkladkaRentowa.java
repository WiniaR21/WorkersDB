package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.worker;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class WorkerSkladkaRentowa extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setReadOnly(true);
    }
}
