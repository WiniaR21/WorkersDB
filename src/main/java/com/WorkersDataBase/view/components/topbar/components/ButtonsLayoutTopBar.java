package com.WorkersDataBase.view.components.topbar.components;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.topbar.components.buttons.AddContractButton;
import com.WorkersDataBase.view.components.topbar.components.buttons.AddWorkerButton;
import com.WorkersDataBase.view.components.topbar.components.buttons.OpenSettingsButton;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ButtonsLayoutTopBar extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final AddWorkerDialog addWorkerDialog;
    private final SettingsDialog settingsDialog;
    private final PositionService positionService;

    public ButtonsLayoutTopBar(
            AddWorkerDialog addWorkerDialog,
            SettingsDialog settingsDialog,
            PositionService positionService
    ) {
        this.addWorkerDialog = addWorkerDialog;
        this.settingsDialog = settingsDialog;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    //  To configure
    AddContractButton addContractButton;
    AddWorkerButton addWorkerButton;
    OpenSettingsButton openSettingsButton;

    @Override
    public void configureComponents() {
        addContractButton = new AddContractButton(positionService);
        addWorkerButton = new AddWorkerButton(addWorkerDialog);
        openSettingsButton = new OpenSettingsButton(settingsDialog);
    }

    @Override
    public void configureFront() {
        setClassName("buttons-bar");
        add(addWorkerButton, addContractButton, openSettingsButton);
    }
}
