package com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;

public class CloseSettingsDialogButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;

    public CloseSettingsDialogButton(SettingsDialog settingsDialog) {
        this.settingsDialog = settingsDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        settingsDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Wyjdź");
        addClickListener(clickEvent ->  clickEvent());
        addClickShortcut(Key.ESCAPE);
    }
}
