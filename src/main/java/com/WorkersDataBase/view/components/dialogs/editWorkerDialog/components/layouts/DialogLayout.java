package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.EditHeader;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class DialogLayout extends VerticalLayout implements ComponentCreator {
    EditHeader editHeader;
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;
    public DialogLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        editHeader = new EditHeader();
        fieldsLayout = new FieldsLayout();
        buttonsLayout = new ButtonsLayout();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        add(
                editHeader,
                fieldsLayout,
                buttonsLayout
        );
    }
}
