package com.WorkersDataBase.view.components.topbar;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.topbar.components.ButtonsLayoutTopBar;
import com.WorkersDataBase.view.components.topbar.components.FilterText;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TopBar extends HorizontalLayout implements ComponentCreator {
    //  Inject by constructor
    private final WorkersGrid grid;
    private final AddWorkerDialog addWorkerDialog;
    private final SettingsDialog settingsDialog;
    private final PositionService positionService;

    //  To configure
    FilterText filterText;
    ButtonsLayoutTopBar buttonsLayout;

    @Override
    public void configureComponents() {
        configureFilterText();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        setWidthFull();
        setPadding(true);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(filterText, buttonsLayout);
    }
    private void configureFilterText(){
        filterText = new FilterText(grid);
        filterText.configure();
    }
    private void configureButtonsLayout(){
        buttonsLayout = new ButtonsLayoutTopBar(
                addWorkerDialog,
                settingsDialog,
                positionService
        );
        buttonsLayout.configure();
    }
}
