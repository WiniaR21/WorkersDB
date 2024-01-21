package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class DismissWorkerButton extends Button implements ComponentCreator, ButtonCreator {
    public DismissWorkerButton() {
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
        setText("Zwolnij pracownika");
        addClickListener(e -> clickEvent());
    }
}
