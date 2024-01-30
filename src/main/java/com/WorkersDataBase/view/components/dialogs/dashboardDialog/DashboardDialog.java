package com.WorkersDataBase.view.components.dialogs.dashboardDialog;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts.DashboardDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class DashboardDialog extends Dialog implements ComponentCreator {
    //  To configure
    DashboardDialogLayout dashboardDialogLayout;
    @Override
    public void configureComponents() {
        setDashboardDialogLayout();
    }

    @Override
    public void configureFront() {
        add(dashboardDialogLayout);
        open();
    }

    private void setDashboardDialogLayout() {
        dashboardDialogLayout = new DashboardDialogLayout(this);
        dashboardDialogLayout.configure();
    }
}
