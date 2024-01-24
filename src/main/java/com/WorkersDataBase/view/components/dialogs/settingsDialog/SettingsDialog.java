package com.WorkersDataBase.view.components.dialogs.settingsDialog;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts.SettingsDialogButtonsLayout;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts.SettingsDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.CloseSettingsDialogButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.buttons.SaveSettingsButton;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class SettingsDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkersGrid workersGrid;

    // To configure
    SettingsDialogLayout settingsDialogLayout;

    @Override
    public void configureComponents(){
       configureSettingsDialogLayout();
    }
    @Override
    public void configureFront() {
        setModal(true);
        setCloseOnOutsideClick(false);
        add(settingsDialogLayout);
    }
    private void configureSettingsDialogLayout(){
        settingsDialogLayout = new SettingsDialogLayout(
                this,
                workersGrid
        );
        settingsDialogLayout.configure();
    }
}
