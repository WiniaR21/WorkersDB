package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.buttons.CloseGeneralCostsDialogButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final GeneralCostsDialog generalCostsDialog;
    private final DashboardDialog dashboardDialog;
    //  To configure
    CloseGeneralCostsDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        add(closeDialogButton);
    }
    private void setCloseDialogButton(){
        closeDialogButton = new CloseGeneralCostsDialogButton(
                generalCostsDialog,
                dashboardDialog
        );
        closeDialogButton.configure();
    }
}
