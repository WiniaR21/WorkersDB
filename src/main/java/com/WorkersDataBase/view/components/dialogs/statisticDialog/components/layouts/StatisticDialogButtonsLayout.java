package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.buttons.CloseStatisticDialogButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final StatisticDialog statisticDialog;
    private final DashboardDialog dashboardDialog;

    //  To configure
    CloseStatisticDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.END);
        add(closeDialogButton);
    }

    private void setCloseDialogButton() {
        closeDialogButton = new CloseStatisticDialogButton(
                statisticDialog,
                dashboardDialog
        );
        closeDialogButton.configure();
    }
}
