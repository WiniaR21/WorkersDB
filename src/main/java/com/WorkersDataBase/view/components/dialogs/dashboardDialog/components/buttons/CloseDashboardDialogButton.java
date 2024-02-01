package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseDashboardDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    @Override
    public void clickEvent() {dashboardDialog.close();}
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zamknij");
        addClickShortcut(Key.ESCAPE);
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(
                ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_ERROR
        );
    }
}
