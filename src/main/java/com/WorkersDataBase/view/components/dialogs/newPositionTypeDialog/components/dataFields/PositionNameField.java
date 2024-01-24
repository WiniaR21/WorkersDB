package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.dataFields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PositionNameField extends TextField implements ComponentCreator {
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
