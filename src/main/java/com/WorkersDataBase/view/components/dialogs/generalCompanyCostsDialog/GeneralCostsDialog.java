package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts.GeneralCostsLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    //  To configure
    GeneralCostsLayout generalCostsLayout;
    @Override
    public void configureComponents() {
        setGeneralCostsLayout();
    }

    @Override
    public void configureFront() {
        add(generalCostsLayout);
        open();
    }

    private void setGeneralCostsLayout() {
        generalCostsLayout = new GeneralCostsLayout(
                this,
                dashboardDialog
        );
        generalCostsLayout.configure();
    }
}
