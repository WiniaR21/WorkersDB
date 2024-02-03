package com.WorkersDataBase.view.components.dialogs.dashboardDialog;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts.DashboardDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
    //  To inject by constructor
    //  Services
    private final ContractGetService    contractGetService;
    private final WorkerGetService      workerGetService;
    private final CompanyFeeGetService  companyFeeGetService;
    private final WorkersFeeGetService  workersFeeGetService;

    //  To configure
    DashboardDialogLayout dialogLayout;

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
        dialogLayout = new DashboardDialogLayout(
                this,
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        dialogLayout.configure();
    }
}
