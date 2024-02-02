package com.WorkersDataBase.view.components.dialogs.dashboardDialog;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.worker.WorkerService;
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
    private final ContractService contractService;
    private final WorkerService workerService;

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
                contractService,
                workerService
        );
        dialogLayout.configure();
    }
}
