package com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.CloseSettingsDialogButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.SaveSettingsButton;
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
    private final CheckBoxLayout checkBoxLayout;

    //  To configure
    SaveSettingsButton saveSettingsButton;
    CloseSettingsDialogButton closeSettingsDialogButton;

    @Override
    public void configureComponents() {
        configureSaveSettingsButton();
        configureCloseSettingsDialogButton();
    }

    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        add(
                saveSettingsButton,
                closeSettingsDialogButton
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
    private void configureCloseSettingsDialogButton(){
        closeSettingsDialogButton = new CloseSettingsDialogButton(settingsDialog);
        closeSettingsDialogButton.configure();
    }
}
