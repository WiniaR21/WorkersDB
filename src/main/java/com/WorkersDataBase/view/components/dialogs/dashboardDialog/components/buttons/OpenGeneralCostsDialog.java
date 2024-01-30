package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OpenGeneralCostsDialog extends Button implements ComponentCreator, ButtonCreator {
    private final DashboardDialog dashboardDialog;
    @Override
    public void clickEvent() {
        GeneralCostsDialog generalCostsDialog = new GeneralCostsDialog(
                dashboardDialog
        );
        generalCostsDialog.configure();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Generalne koszty firmy");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
