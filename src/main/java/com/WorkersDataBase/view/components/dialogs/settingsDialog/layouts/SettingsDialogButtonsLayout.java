package com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.CloseSettingsDialogButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.SaveSettingsButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SettingsDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    private final WorkersGrid workersGrid;
    private final CheckBoxLayout checkBoxLayout;

    public SettingsDialogButtonsLayout(
            SettingsDialog settingsDialog,
            WorkersGrid workersGrid,
            CheckBoxLayout checkBoxLayout
    ) {
        this.settingsDialog = settingsDialog;
        this.workersGrid = workersGrid;
        this.checkBoxLayout = checkBoxLayout;

        configureComponents();
        configureFront();
    }

    //  To configure
    SaveSettingsButton saveSettingsButton;
    CloseSettingsDialogButton closeSettingsDialogButton;

    @Override
    public void configureComponents() {
        saveSettingsButton = new SaveSettingsButton(
                workersGrid,
                settingsDialog,
                checkBoxLayout
        );

        closeSettingsDialogButton = new CloseSettingsDialogButton(settingsDialog);
    }

    @Override
    public void configureFront() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        add(
                saveSettingsButton,
                closeSettingsDialogButton
        );
    }
}
