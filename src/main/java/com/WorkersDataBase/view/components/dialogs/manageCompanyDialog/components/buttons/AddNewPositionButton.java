package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddNewPositionButton extends Button implements ComponentCreator ,ButtonCreator {
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        manageCompanyDialog.close();
        openNewPositionTypeDialog();
    }
    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront() {
        setText("Nowy rodzaj stanowiska");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
    private void openNewPositionTypeDialog(){
        NewPositionTypeDialog newPositionTypeDialog =
                new NewPositionTypeDialog(
                        positionService,
                        manageCompanyDialog,
                        notification
                );

        newPositionTypeDialog.configure();
    }
}
