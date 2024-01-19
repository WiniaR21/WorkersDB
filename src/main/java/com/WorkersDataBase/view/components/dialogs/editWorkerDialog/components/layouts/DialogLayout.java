package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class DialogLayout extends VerticalLayout implements ComponentCreator {
    FieldsLayout fieldsLayout;
    public DialogLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        fieldsLayout = new FieldsLayout();
    }

    @Override
    public void configureFront() {
        add(fieldsLayout);
    }
}
