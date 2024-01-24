package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddWorkerButton extends Button implements ComponentCreator, ButtonCreator {
    // To inject by constructor
    private final AddWorkerDialog addWorkerDialog;

    @Override
    public void clickEvent() {
        addWorkerDialog.open();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Dodaj pracownka");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
