package com.WorkersDataBase.view.components.dialogs.statisticDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.buttons.CloseStatisticDialogButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final StatisticDialog statisticDialog;
    private final DashboardDialog dashboardDialog;

    //  To configure
    CloseStatisticDialogButton closeStatisticDialogButton;
    @Override
    public void configureComponents() {
        setCloseStatisticDialogButton();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.END);
        add(closeStatisticDialogButton);
    }

    private void setCloseStatisticDialogButton() {
        closeStatisticDialogButton = new CloseStatisticDialogButton(
                statisticDialog,
                dashboardDialog
        );
        closeStatisticDialogButton.configure();
    }
}
