package com.WorkersDataBase.service.dialogs.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class RejectButton extends Button implements ComponentCreator, ButtonCreator {
    public RejectButton() {
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
        setText("Odrzuć");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
