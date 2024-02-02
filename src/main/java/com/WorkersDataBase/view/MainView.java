package com.WorkersDataBase.view;


import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.grid.WorkersGridSettings;
import com.WorkersDataBase.view.components.line.LineBetweenComponents;
import com.WorkersDataBase.view.components.topbar.TopBar;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@PageTitle("Pracownicy")
@Route("strona-glowna")
@RequiredArgsConstructor
public class MainView extends VerticalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final PositionService positionService;
    private final ContractService contractService;
    private final WorkersGridSettings workersGridSettings;
    private final ServicePushNotification notification;

    //  To configure
    WorkersGrid workersGrid;
    TopBar topBar;
    LineBetweenComponents line;

    @Override @PostConstruct
    public void configureComponents() {
        line = new LineBetweenComponents();

        configureGrid();
        configureTopBar();
        configureFront();
    }
    @Override
    public void configureFront(){
        setClassName("main-view");
        setPadding(false);
        getStyle().setDisplay(Style.Display.BLOCK);
        setSizeFull();

        add(
                topBar,
                workersGrid
        );
    }
    private void configureGrid(){
        workersGrid = new WorkersGrid(
                workerService,
                positionService,
                contractService,
                workersGridSettings,
                notification
        );
        workersGrid.configure();
    }
    private void configureTopBar(){
        topBar = new TopBar(
                workerService,
                workersGrid,
                positionService,
                notification,
                contractService
        );
        topBar.configure();
    }
}
