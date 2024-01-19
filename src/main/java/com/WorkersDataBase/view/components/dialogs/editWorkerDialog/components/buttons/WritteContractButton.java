package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    public WritteContractButton() {
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
        setText("Daj umowę");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
