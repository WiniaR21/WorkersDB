package com.WorkersDataBase.view.components.dialogs.settingsDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts.CheckBoxLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveSettingsButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final WorkersGrid workersGrid;
    private final CheckBoxLayout checkBoxLayout;
    private final SettingsDialog settingsDialog;

    @Override
    public void clickEvent() {
        workersGrid.setBySetting(checkBoxLayout.getCheckBoxValue());
        settingsDialog.close();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ENTER);
    }
}
