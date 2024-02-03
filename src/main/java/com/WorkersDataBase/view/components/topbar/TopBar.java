package com.WorkersDataBase.view.components.topbar;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.components.topbar.components.ButtonsLayoutTopBar;
import com.WorkersDataBase.view.components.topbar.components.FilterText;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TopBar
        extends HorizontalLayout
        implements ComponentCreator
{
    //Components
    private final WorkersGrid               workersGrid;
    private final ServicePushNotification   notification;
    //Services
    private final WorkerService             workerService;
    private final PositionService           positionService;
    private final ContractService           contractService;
    // Get Services
    private final CompanyFeeGetService      companyFeeGetService;
    private final WorkerGetService          workerGetService;
    private final WorkersFeeGetService      workersFeeGetService;
    private final ContractGetService        contractGetService;

                    // To configure
                    FilterText              filterText;
                    ButtonsLayoutTopBar     buttonsLayout;

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

        add(
                filterText,
                buttonsLayout
        );
    }
    private void configureFilterText(){
        filterText = new FilterText(workersGrid);
        filterText.configure();
    }
    private void configureButtonsLayout(){
        buttonsLayout = new ButtonsLayoutTopBar(
                workersGrid,
                notification,
                workerService,
                positionService,
                contractService,
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        buttonsLayout.configure();
    }
}
