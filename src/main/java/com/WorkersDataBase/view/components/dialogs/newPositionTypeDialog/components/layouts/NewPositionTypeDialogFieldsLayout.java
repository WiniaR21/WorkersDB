package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.fields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class NewPositionTypeDialogFieldsLayout extends HorizontalLayout implements ComponentCreator {
    //  To configure
    PositionNameField positionNameField;
    @Override
    public void configureComponents() {
        setPositionNameField();
    }
    @Override
    public void configureFront() {
        add(positionNameField);
    }
    private void setPositionNameField() {
        positionNameField = new PositionNameField();
        positionNameField.configure();
    }
}
