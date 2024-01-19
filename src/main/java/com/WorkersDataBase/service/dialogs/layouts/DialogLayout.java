package com.WorkersDataBase.service.dialogs.layouts;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout implements ComponentCreator {
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    public DialogLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        fieldsLayout = new FieldsLayout();
        buttonsLayout = new ButtonsLayout();
    }

    @Override
    public void configureFront() {
        add(
                fieldsLayout,
                buttonsLayout
        );
    }
}
