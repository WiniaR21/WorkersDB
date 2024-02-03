package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts.GeneralCostsDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    //  Services
    private final CompanyFeeGetService companyFeeGetService;
    //  To configure
    GeneralCostsDialogLayout dialogLayout;

    @Override
    public void configureComponents() {
        setGeneralCostsLayout();
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
        open();
    }

    private void setGeneralCostsLayout() {
        dialogLayout = new GeneralCostsDialogLayout(
                this,
                dashboardDialog,
                companyFeeGetService
        );
        dialogLayout.configure();
    }
}
