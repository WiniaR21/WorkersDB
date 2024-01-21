package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

import java.util.Set;

public class OpenSettingsButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    public OpenSettingsButton(SettingsDialog settingsDialog) {
        this.settingsDialog = settingsDialog;

        configureComponents();
        configureFront();
    }
    @Override
    public void clickEvent() {
        settingsDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Ustawienia");
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        addClickListener(clickEvent -> clickEvent());
    }

}
