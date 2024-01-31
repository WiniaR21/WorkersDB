package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.fields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveNewPositionType extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final PositionNameField positionNameField;
    private final PositionService positionService;
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {

        int status = positionService.addNewPositionType(getPositionNameFromUser());

        statusResponse(status);
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    }
    public String getPositionNameFromUser(){
        return positionNameField.getValue();
    }
    private void statusResponse(int status){
        if (status ==  0) notification.pushNewPositionSuccess(getPositionNameFromUser());
        if (status == -1) notification.pushUserTryingAddNullPositionInfo();
        if (status == -2) notification.pushUniquePositionError();
        if (status == -3) notification.pushToShortPositionNameInfo();

        if(status == 0) newPositionTypeDialog.close();
    }
}
