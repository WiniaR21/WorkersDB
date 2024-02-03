package com.WorkersDataBase.view.components.topbar.components;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.topbar.components.buttons.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ButtonsLayoutTopBar
        extends HorizontalLayout
        implements ComponentCreator
{
    //  To inject by constructor
    private final WorkersGrid               workersGrid;
    private final ServicePushNotification   notification;
    //  Services
    private final WorkerService             workerService;
    private final PositionService           positionService;
    private final ContractService           contractService;
        //  Get Services
    private final ContractGetService        contractGetService;
    private final WorkerGetService          workerGetService;
    private final CompanyFeeGetService      companyFeeGetService;
    private final WorkersFeeGetService      workersFeeGetService;

                //  To configure
                AddContractButton           addContractButton;
                AddWorkerButton             addWorkerButton;
                OpenSettingsButton          openSettingsButton;
                DashboardButton             dashboardButton;
                InjectTestDataButton        injectTestDataButton;

    @Override
    public void configureComponents() {
        configureAddContractButton();
        configureAddWorkerButton();
        configureOpenSettingsButton();
        configureDashboardButton();
        configureInjectTestDataButton();
    }
    @Override
    public void configureFront() {
        setClassName("buttons-bar");
        add(
                addWorkerButton,
                addContractButton,
                openSettingsButton,
                dashboardButton,
                injectTestDataButton
        );
    }
    private void configureAddContractButton(){
        addContractButton = new AddContractButton(
                positionService,
                notification
        );
        addContractButton.configure();
    }
    private void configureAddWorkerButton(){
        addWorkerButton = new AddWorkerButton(
                workerService,
                workersGrid,
                notification
        );
        addWorkerButton.configure();
    }
    private void configureOpenSettingsButton(){
        openSettingsButton = new OpenSettingsButton(workersGrid);
        openSettingsButton.configure();
    }
    private void configureDashboardButton(){
        dashboardButton = new DashboardButton(
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        dashboardButton.configure();
    }
    private void configureInjectTestDataButton(){
        injectTestDataButton = new InjectTestDataButton(
                workerService,
                workersGrid,
                contractService,
                positionService
        );
        injectTestDataButton.configure();
    }
}
