package com.WorkersDataBase.view.components.topbar.components;

import com.WorkersDataBase.service.companyFee.CompanyFeeGetService;
import com.WorkersDataBase.service.contract.ContractGetService;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionPostService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
import com.WorkersDataBase.service.workersFee.WorkersFeeGetService;
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
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    //  Services
    private final WorkerPostService workerPostService;
    private final PositionPostService       positionPostService;
    private final ContractPostService contractPostService;
    private final ContractGetService contractGetService;
    private final WorkerGetService workerGetService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;
    private final PositionGetService positionGetService;
    private final PositionDeleteService     positionDeleteService;

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
               notification,
                positionPostService,
                positionGetService,
                positionDeleteService
        );
        addContractButton.configure();
    }
    private void configureAddWorkerButton(){
        addWorkerButton = new AddWorkerButton(
                workerPostService,
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
                workerPostService,
                workersGrid,
                contractPostService,
                positionGetService,
                workerGetService
        );
        injectTestDataButton.configure();
    }
}
