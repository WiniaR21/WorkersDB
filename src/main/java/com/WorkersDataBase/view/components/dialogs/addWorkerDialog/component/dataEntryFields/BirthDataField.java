package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;

public class BirthDataField extends DatePicker implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Data urodzin");
        setTooltipText("Data urodzin");
        setClearButtonVisible(true);
        setPrefixComponent(VaadinIcon.VAADIN_H.create());
    }
}
