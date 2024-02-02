package com.WorkersDataBase.view.components.topbar;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.topbar.components.ButtonsLayoutTopBar;
import com.WorkersDataBase.view.components.topbar.components.FilterText;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TopBar extends HorizontalLayout implements ComponentCreator {
    //  Inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final PositionService positionService;
    private final ServicePushNotification notification;

    private final ContractService contractService;


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
        filterText = new FilterText(workersGrid);
        filterText.configure();
    }
    private void configureButtonsLayout(){
        buttonsLayout = new ButtonsLayoutTopBar(
                workerService,
                workersGrid,
                positionService,
                notification,
                contractService
        );
        buttonsLayout.configure();
    }
}
