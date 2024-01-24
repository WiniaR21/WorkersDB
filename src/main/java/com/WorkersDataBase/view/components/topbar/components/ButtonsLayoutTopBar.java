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
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ButtonsLayoutTopBar extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final AddWorkerDialog addWorkerDialog;
    private final SettingsDialog settingsDialog;
    private final PositionService positionService;

    //  To configure
    AddContractButton addContractButton;
    AddWorkerButton addWorkerButton;
    OpenSettingsButton openSettingsButton;

    @Override
    public void configureComponents() {
        configureAddContractButton();
        configureAddWorkerButton();
        configureOpenSettingsButton();
    }
    @Override
    public void configureFront() {
        setClassName("buttons-bar");
        add(addWorkerButton, addContractButton, openSettingsButton);
    }
    private void configureAddContractButton(){
        addContractButton = new AddContractButton(positionService);
        addContractButton.configure();
    }
    private void configureAddWorkerButton(){
        addWorkerButton = new AddWorkerButton(addWorkerDialog);
        addWorkerButton.configure();
    }
    private void configureOpenSettingsButton(){
        openSettingsButton = new OpenSettingsButton(settingsDialog);
        openSettingsButton.configure();
    }
}
