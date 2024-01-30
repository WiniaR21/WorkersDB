package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.costFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class GeneralRentowa extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Składki rentowe");
        setReadOnly(true);
    }
}
