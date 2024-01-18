package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class AddContractButton extends Button implements ComponentCreator, ButtonCreator {
    public AddContractButton() {
        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {

    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zarządzaj pracownikiem");
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        addClickListener(clickEvent -> clickEvent());
    }
}
