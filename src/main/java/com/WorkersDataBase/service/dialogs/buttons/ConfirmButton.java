package com.WorkersDataBase.service.dialogs.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class ConfirmButton extends Button implements ComponentCreator, ButtonCreator {

    public ConfirmButton() {
        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        System.out.println(this);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Potwierdź");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
