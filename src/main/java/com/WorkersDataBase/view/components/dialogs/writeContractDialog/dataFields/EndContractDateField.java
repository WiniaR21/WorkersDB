package com.WorkersDataBase.view.components.dialogs.writeContractDialog.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;

public class EndContractDateField extends DatePicker implements ComponentCreator {
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Dzień zakończenia umowy");
        setTooltipText("Dzień zakończenia umowy");
        setClearButtonVisible(true);
        setPrefixComponent(VaadinIcon.VAADIN_H.create());
    }
}
