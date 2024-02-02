package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseGeneralCostsDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final GeneralCostsDialog generalCostsDialog;
    private final DashboardDialog dashboardDialog;
    @Override
    public void clickEvent() {
        generalCostsDialog.close();
        dashboardDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zamknij");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
