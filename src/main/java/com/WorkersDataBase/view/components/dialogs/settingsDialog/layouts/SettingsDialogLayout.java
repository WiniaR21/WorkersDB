package com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.HeaderSettings;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.CloseSettingsDialogButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.SaveSettingsButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SettingsDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    private final WorkersGrid workersGrid;

    public SettingsDialogLayout(
            SettingsDialog settingsDialog,
            WorkersGrid workersGrid
    ) {
        this.settingsDialog = settingsDialog;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    //  To configure
    HeaderSettings headerSettings;
    CheckBoxLayout checkBoxLayout;
    SettingsDialogButtonsLayout settingsDialogButtonsLayout;

    @Override
    public void configureComponents() {
        headerSettings = new HeaderSettings();

        checkBoxLayout = new CheckBoxLayout();

        settingsDialogButtonsLayout = new SettingsDialogButtonsLayout(
                settingsDialog,
                workersGrid,
                checkBoxLayout
        );


    }

    @Override
    public void configureFront() {
        add(
                headerSettings,
                checkBoxLayout,
                settingsDialogButtonsLayout
        );
    }
}
