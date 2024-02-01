package com.WorkersDataBase.view.components.dialogs.dashboardDialog;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts.DashboardDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogCreator;
import com.vaadin.flow.component.dialog.Dialog;

public class DashboardDialog
        extends Dialog
        implements ComponentCreator, DialogCreator
{
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
        dialogLayout = new DashboardDialogLayout(this);
        dialogLayout.configure();
    }
}
