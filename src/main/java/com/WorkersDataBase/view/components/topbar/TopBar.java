package com.WorkersDataBase.view.components.topbar;

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
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    //Services
    private final WorkerPostService workerPostService;
    private final PositionPostService       positionPostService;
    private final ContractPostService contractPostService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkerGetService workerGetService;
    private final WorkersFeeGetService workersFeeGetService;
    private final ContractGetService contractGetService;
    private final PositionGetService positionGetService;
    private final PositionDeleteService     positionDeleteService;

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
                notification,
                workersGrid,
                workerPostService,
                positionPostService,
                contractPostService,
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService,
                positionGetService,
                positionDeleteService
        );
        buttonsLayout.configure();
    }
}
