package com.WorkersDataBase.view.components.dialogs.statisticDialog;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.layouts.StatisticsDialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    //  To configure
    StatisticsDialogLayout statisticsDialogLayout;

    @Override
    public void configureComponents() {
        setStatisticsDialogLayout();
    }

    @Override
    public void configureFront() {
        add(statisticsDialogLayout);
        open();
    }

    private void setStatisticsDialogLayout() {
       statisticsDialogLayout = new StatisticsDialogLayout(
               this,
               dashboardDialog

       );
       statisticsDialogLayout.configure();
    }

}
