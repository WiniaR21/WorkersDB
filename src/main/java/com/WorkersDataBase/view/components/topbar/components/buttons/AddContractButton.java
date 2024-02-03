package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.service.position.PositionPostService;
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
    //  Components
    private final ServicePushNotification   notification;
    //  Services
    private final PositionPostService       positionPostService;
    private final PositionGetService        positionGetService;
    private final PositionDeleteService     positionDeleteService;

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
                new ManageCompanyDialog(
                        notification,
                        positionPostService,
                        positionGetService,
                        positionDeleteService
                );
        manageCompanyDialog.configure();
    }
}
