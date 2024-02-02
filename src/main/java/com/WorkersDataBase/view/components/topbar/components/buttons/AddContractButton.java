package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddContractButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final PositionService positionService;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        openManageCompanyDialog();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zarządzaj firmą");
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        addClickListener(clickEvent -> clickEvent());
    }
    private void openManageCompanyDialog(){
        ManageCompanyDialog manageCompanyDialog =
                new ManageCompanyDialog(positionService, notification);
        manageCompanyDialog.configure();
    }
}
