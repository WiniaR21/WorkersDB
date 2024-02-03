package com.WorkersDataBase.view;


import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.grid.WorkersGridSettings;
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
public class MainView
        extends VerticalLayout
        implements ComponentCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGridSettings       workersGridSettings;
    //  Services
    private final WorkerService             workerService;
    private final PositionService           positionService;
    private final ContractService           contractService;
    //  Get Services
    private final CompanyFeeGetService      companyFeeGetService;
    private final WorkersFeeGetService      workersFeeGetService;
    private final WorkerGetService          workerGetService;
    private final ContractGetService        contractGetService;

                    //  To configure
                    WorkersGrid             workersGrid;
                    TopBar                  topBar;

    @Override @PostConstruct
    public void configureComponents() {
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
                workersGrid,
                notification,
                workerService,
                positionService,
                contractService,
                companyFeeGetService,
                workerGetService,
                workersFeeGetService,
                contractGetService
        );
        topBar.configure();
    }
}
