package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class SaveChangesButton extends Button implements ComponentCreator, ButtonCreator {
    public SaveChangesButton() {
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
        setText("Zapisz");
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
