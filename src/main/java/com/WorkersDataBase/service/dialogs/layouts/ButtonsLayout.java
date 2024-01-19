package com.WorkersDataBase.service.dialogs.layouts;

import com.WorkersDataBase.service.dialogs.buttons.ConfirmButton;
import com.WorkersDataBase.service.dialogs.buttons.RejectButton;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    ConfirmButton confirmButton;
    RejectButton rejectButton;

    public ButtonsLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        confirmButton = new ConfirmButton();
        rejectButton = new RejectButton();
    }

    @Override
    public void configureFront() {
        add(confirmButton, rejectButton);
    }
}
