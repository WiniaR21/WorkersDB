package com.WorkersDataBase.view.components.dialogs.settingsDialog;

import com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts.SettingsDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SettingsDialog extends Dialog implements ComponentCreator, DialogCreator {
    //  To inject by constructor
    private final WorkersGrid workersGrid;

    // To configure
    SettingsDialogLayout dialogLayout;

    @Override
    public void configureComponents(){
        setDialogLayout();
    }
    @Override
    public void configureFront() {
        setModal(true);
        setCloseOnOutsideClick(false);
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        dialogLayout = new SettingsDialogLayout(
                this,
                workersGrid
        );
        dialogLayout.configure();
    }
}
