package com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.components.buttons.CloseSettingsDialogButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.components.buttons.SaveSettingsButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SettingsDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    private final WorkersGrid workersGrid;
    private final SettingsDialogCheckBoxLayout checkBoxLayout;

    //  To configure
    SaveSettingsButton saveSettingsButton;
    CloseSettingsDialogButton closeDialogButton;

    @Override
    public void configureComponents() {
        configureSaveSettingsButton();
        setCloseDialogButton();
    }
    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        add(
                saveSettingsButton,
                closeDialogButton
        );
    }
    private void configureSaveSettingsButton(){
        saveSettingsButton = new SaveSettingsButton(
                workersGrid,
                checkBoxLayout,
                settingsDialog
        );
        saveSettingsButton.configure();
    }
    private void setCloseDialogButton(){
        closeDialogButton = new CloseSettingsDialogButton(settingsDialog);
        closeDialogButton.configure();
    }
}
