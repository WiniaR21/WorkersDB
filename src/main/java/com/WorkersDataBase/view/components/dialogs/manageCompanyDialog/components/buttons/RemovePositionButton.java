package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
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
    //  To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;


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
                        positionService,
                        manageCompanyDialog,
                        notification
                );
        removePositionDialog.configure();
    }
}
