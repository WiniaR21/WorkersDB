package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.costFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class GeneralFunduszPracy extends TextField implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Skł. na fundusz pracy ");
        setReadOnly(true);
    }
}
