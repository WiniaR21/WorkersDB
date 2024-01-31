package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;

public class StartContractDateField extends DatePicker implements ComponentCreator {

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Dzień rozpoczęcia umowy");
        setTooltipText("Dzień rozpoczęcia umowy");
        setClearButtonVisible(true);
        setPrefixComponent(VaadinIcon.VAADIN_H.create());
    }
}
