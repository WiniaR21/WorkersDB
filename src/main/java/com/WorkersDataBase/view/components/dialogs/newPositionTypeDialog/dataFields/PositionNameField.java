package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

@Getter
public class PositionNameField extends TextField implements ComponentCreator {

    public PositionNameField() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Nazwa Stanowiska");
        setMinLength(3);
        setErrorMessage("Nazwa jest za krótka");
        setClearButtonVisible(true);
        setRequiredIndicatorVisible(true);
    }
}
