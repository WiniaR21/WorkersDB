package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    @Override
    public void clickEvent() {
        DashboardDialog dashboardDialog = new DashboardDialog();
        dashboardDialog.configure();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Statystyki");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
