package com.WorkersDataBase.view.components.topbar;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.topbar.components.ButtonsLayoutTopBar;
import com.WorkersDataBase.view.components.topbar.components.FilterText;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TopBar extends HorizontalLayout implements ComponentCreator {

    //  Inject by constructor
    private final WorkersGrid grid;
    private final AddWorkerDialog addWorkerDialog;
    private final SettingsDialog settingsDialog;


    public TopBar(WorkersGrid grid, AddWorkerDialog addWorkerDialog, SettingsDialog settingsDialog) {
       this.grid = grid;
       this.addWorkerDialog = addWorkerDialog;
       this.settingsDialog = settingsDialog;

       configureComponents();
       configureFront();
    }

    //  To configure
    FilterText filterText;
    ButtonsLayoutTopBar buttonsLayout;

    @Override
    public void configureComponents() {
        filterText = new FilterText(grid);

        buttonsLayout = new ButtonsLayoutTopBar(
                addWorkerDialog,
                settingsDialog
        );
    }

    @Override
    public void configureFront() {
        setWidthFull();
        setPadding(true);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(filterText, buttonsLayout);
    }
}
