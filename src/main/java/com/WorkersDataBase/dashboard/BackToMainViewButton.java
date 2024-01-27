package com.WorkersDataBase.dashboard;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class BackToMainViewButton extends Button implements ComponentCreator, ButtonCreator {
    @Override
    public void clickEvent() {
        getUI().ifPresent(ui -> ui.navigate("strona-glowna"));
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Strona główna");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
