package com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class MeanCostForWorker extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Śr. koszt za pracownika");
        setReadOnly(true);
    }
}
