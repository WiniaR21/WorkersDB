package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons.CloseDashboardDialogButton;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons.OpenGeneralCostsDialog;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons.OpenStatisticsDialogButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardDialogButtonsLayout
        extends VerticalLayout
        implements ComponentCreator
{
    //  To inject by constructor
    private final DashboardDialog       dashboardDialog;
    //  Services
    private final ContractGetService    contractGetService;
    private final WorkerGetService      workerGetService;
    private final CompanyFeeGetService  companyFeeGetService;
    private final WorkersFeeGetService  workersFeeGetService;
    //  To configure
    OpenStatisticsDialogButton          openStatisticsDialogButton;
    OpenGeneralCostsDialog              openGeneralCostsDialog;
    CloseDashboardDialogButton          closeDialogButton;

    @Override
    public void configureComponents() {
        setOpenStatisticsDialogButton();
        setOpenGeneralCostsDialog();
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                openStatisticsDialogButton,
                openGeneralCostsDialog,
                closeDialogButton
        );
    }
    private void setOpenStatisticsDialogButton() {
        openStatisticsDialogButton = new OpenStatisticsDialogButton(
                dashboardDialog,
                workerGetService,
                contractGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        openStatisticsDialogButton.configure();
    }
    private void setOpenGeneralCostsDialog(){
        openGeneralCostsDialog = new OpenGeneralCostsDialog(
                dashboardDialog,
                companyFeeGetService
        );
        openGeneralCostsDialog.configure();
    }

    private void setCloseDialogButton() {
        closeDialogButton = new CloseDashboardDialogButton(dashboardDialog);
        closeDialogButton.configure();
    }
}
