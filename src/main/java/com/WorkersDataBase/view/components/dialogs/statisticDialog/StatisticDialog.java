package com.WorkersDataBase.view.components.dialogs.statisticDialog;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts.StatisticsDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    //  Services
    private final WorkerGetService workerGetService;
    private final ContractGetService contractGetService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;

    //  To configure
    StatisticsDialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        setDialogLayout();
    }
    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }
    @Override
    public void setDialogLayout() {
        dialogLayout = new StatisticsDialogLayout(
                this,
                dashboardDialog,
                workerGetService,
                contractGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        dialogLayout.configure();
    }
}
