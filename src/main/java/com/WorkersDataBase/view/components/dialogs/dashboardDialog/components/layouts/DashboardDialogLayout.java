package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardDialogLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;

    //  To configure
    DashboardDialogButtonsLayout buttonsLayout;
    @Override
    public void configureComponents() {
        setButtonsLayout();
    }

    @Override
    public void configureFront() {
        add(buttonsLayout);
    }

    private void setButtonsLayout() {
        buttonsLayout = new DashboardDialogButtonsLayout(dashboardDialog);
        buttonsLayout.configure();
    }
}
