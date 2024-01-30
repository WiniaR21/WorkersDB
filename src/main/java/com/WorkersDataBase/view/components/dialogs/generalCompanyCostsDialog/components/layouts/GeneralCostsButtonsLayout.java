package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.buttons.CloseGeneralCostsDialogButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final GeneralCostsDialog generalCostsDialog;
    private final DashboardDialog dashboardDialog;
    //  To configure
    CloseGeneralCostsDialogButton closeGeneralCostsDialogButton;
    @Override
    public void configureComponents() {
        setCloseGeneralCostsDialogButton();
    }

    @Override
    public void configureFront() {
        add(closeGeneralCostsDialogButton);
    }
    private void setCloseGeneralCostsDialogButton(){
        closeGeneralCostsDialogButton = new CloseGeneralCostsDialogButton(
                generalCostsDialog,
                dashboardDialog
        );
        closeGeneralCostsDialogButton.configure();
    }
}
