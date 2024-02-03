package com.WorkersDataBase.view;


import com.WorkersDataBase.service.companyFee.CompanyFeeGetService;
import com.WorkersDataBase.service.contract.ContractGetService;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionPostService;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.service.workersFee.WorkersFeeGetService;
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
    private final ServicePushNotification notification;
    private final WorkersGridSettings workersGridSettings;
    //  Services
    private final WorkerPostService workerPostService;
    private final PositionPostService positionPostService;
    private final ContractPostService contractPostService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;
    private final WorkerGetService workerGetService;
    private final ContractGetService contractGetService;
    private final PositionGetService positionGetService;
    private final PositionDeleteService positionDeleteService;
    private final WorkerDeleteService workerDeleteService;

    //  To configure
    WorkersGrid workersGrid;
    TopBar topBar;

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
              notification,
                workersGridSettings,
                workerPostService,
                contractPostService,
                positionGetService,
                workerDeleteService,
                workerGetService
        );
        workersGrid.configure();
    }
    private void configureTopBar(){
        topBar = new TopBar(
                notification,
                workersGrid,
                workerPostService,
                positionPostService,
                contractPostService,
                companyFeeGetService,
                workerGetService,
                workersFeeGetService,
                contractGetService,
                positionGetService,
                positionDeleteService
        );
        topBar.configure();
    }
}
