package com.WorkersDataBase.view;


import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.line.LineBetweenComponents;
import com.WorkersDataBase.view.components.topbar.TopBar;
import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@PageTitle("Pracownicy")
@Route("strona-glowna")
@RequiredArgsConstructor
public class MainView extends VerticalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService workerService;
    private final PositionService positionService;
    private final ContractService contractService;

    //  To configure
    WorkersGrid workersGrid;
    TopBar topBar;
    LineBetweenComponents line;

    @Override @PostConstruct @Order(1)
    public void configureComponents() {
        line = new LineBetweenComponents();

        configureGrid();
        configureTopBar();
    }
    @Override @PostConstruct @Order(2)
    public void configureFront(){
        setClassName("main-view");
        setPadding(false);
        getStyle().setDisplay(Style.Display.BLOCK);
        setSizeFull();

        add(
                topBar,
                line,
                workersGrid
        );
    }
    private void configureGrid(){
        workersGrid = new WorkersGrid(
                workerService,
                positionService,
                contractService
        );
        workersGrid.configure();
    }
    private void configureTopBar(){
        topBar = new TopBar(
                workerService,
                workersGrid,
                positionService
        );
        topBar.configure();
    }

}
