package com.WorkersDataBase.view.components.topbar.components;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.topbar.components.buttons.AddContractButton;
import com.WorkersDataBase.view.components.topbar.components.buttons.AddWorkerButton;
import com.WorkersDataBase.view.components.topbar.components.buttons.OpenSettingsButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ButtonsLayoutTopBar extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
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
        addWorkerButton = new AddWorkerButton(workerService, workersGrid);
        addWorkerButton.configure();
    }
    private void configureOpenSettingsButton(){
        openSettingsButton = new OpenSettingsButton(workersGrid);
        openSettingsButton.configure();
    }
}
