package com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts.CheckBoxLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class SaveSettingsButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    WorkersGrid workersGrid;
    CheckBoxLayout checkBoxLayout;
    SettingsDialog settingsDialog;

    public SaveSettingsButton(WorkersGrid workersGrid, SettingsDialog settingsDialog, CheckBoxLayout checkBoxLayout) {
        this.workersGrid = workersGrid;
        this.settingsDialog = settingsDialog;
        this.checkBoxLayout = checkBoxLayout;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        workersGrid.setBySetting(checkBoxLayout.getCheckBoxValue());
        settingsDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ENTER);
    }
}
