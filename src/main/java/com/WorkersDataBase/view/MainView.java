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
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Pracownicy")
@Route("strona-glowna")
public class MainView extends VerticalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerService service;
    private final PositionService positionService;
    private final ContractService contractService;
    @Autowired
    public MainView(
            WorkerService service,
            PositionService positionService,
            ContractService contractService
    ) {
        this.service = service;
        this.positionService = positionService;
        this.contractService = contractService;

        configureComponents();
        configureFront();
    }

    //  To configure
    WorkersGrid grid;
    AddWorkerDialog addWorkerDialog;
    SettingsDialog settingsDialog;
    TopBar topBar;
    LineBetweenComponents line;

    @Override
    public void configureComponents() {
        grid = new WorkersGrid(service, positionService, contractService);

        addWorkerDialog = new AddWorkerDialog(service, grid);

        settingsDialog = new SettingsDialog(grid);

        topBar = new TopBar(grid,addWorkerDialog,settingsDialog, positionService);

        line = new LineBetweenComponents();
    }
    @Override
    public void configureFront(){
        setClassName("main-view");
        setPadding(false);
        getStyle().setDisplay(Style.Display.BLOCK);
        setSizeFull();
        add(topBar, line, grid);
    }

}
