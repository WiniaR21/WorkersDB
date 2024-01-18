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


import java.util.HashSet;
import java.util.Set;
@Getter
public class SettingsDialog extends Dialog implements ComponentCreator {

    //  To inject by constructor
    WorkersGrid workersGrid;

    // To configure
    SettingsDialogLayout settingsDialogLayout;


    public SettingsDialog(WorkersGrid grid) {
        this.workersGrid = grid;

        configureComponents();
        configureFront();
    }
    @Override
    public void configureComponents(){
        settingsDialogLayout = new SettingsDialogLayout(
                this,
                workersGrid
        );

    }
    @Override
    public void configureFront() {
        setModal(true);
        setCloseOnOutsideClick(false);
        add(settingsDialogLayout);
    }



}
