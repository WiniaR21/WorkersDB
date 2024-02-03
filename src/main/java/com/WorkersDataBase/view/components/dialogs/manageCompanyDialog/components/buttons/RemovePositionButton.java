package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final ManageCompanyDialog       manageCompanyDialog;
    //  Services
    private final PositionGetService        positionGetService;
    private final PositionDeleteService     positionDeleteService;

    @Override
    public void clickEvent() {
        manageCompanyDialog.close();
        openRemovePositionDialog();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Usuń rodzaj stanowiska");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
    private void openRemovePositionDialog(){
        RemovePositionDialog removePositionDialog =
                new RemovePositionDialog(
                        notification,
                        manageCompanyDialog,
                        positionDeleteService,
                        positionGetService
                );
        removePositionDialog.configure();
    }
}
