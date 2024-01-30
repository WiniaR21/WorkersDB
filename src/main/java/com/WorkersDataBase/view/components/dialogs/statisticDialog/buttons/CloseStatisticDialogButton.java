package com.WorkersDataBase.view.components.dialogs.statisticDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseStatisticDialogButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final StatisticDialog statisticDialog;
    private final DashboardDialog dashboardDialog;
    @Override
    public void clickEvent() {
        statisticDialog.close();
        dashboardDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zamknij");
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickListener(buttonClickEvent -> clickEvent());
        addClickShortcut(Key.ESCAPE);
    }
}
