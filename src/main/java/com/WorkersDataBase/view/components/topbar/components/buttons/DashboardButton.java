package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardButton extends Button implements ComponentCreator, ButtonCreator {
    @Override
    public void clickEvent() {
        getUI().ifPresent(ui -> ui.navigate("statystyki"));
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Statystyki");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
