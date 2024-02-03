package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  Components
    private final ServicePushNotification notification;
    private final ComboBox<Position> positions;
    private final RemovePositionDialog removePositionDialog;
    //  Services
    private final PositionDeleteService positionDeleteService;

    @Override
    public void clickEvent() {
        int status = positionDeleteService.deletePosition(getPositionFromUser());
        statusResponse(status);
    }
    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront() {
        setText("Usuń");
        addThemeVariants(ButtonVariant.LUMO_ERROR);
        addClickListener(buttonClickEvent -> clickEvent());
    }
    private Position getPositionFromUser(){
        return positions.getValue();
    }
    private void statusResponse(int status){

        if (status ==  0) {
            notification.pushDeletePositionSuccess(getPositionFromUser());
            removePositionDialog.close();
        }
        else if (status == -1){
            notification.pushUserTryingAddNullPositionInfo();
        }
        else {
            notification.pushDeletingPositionConflictInfo();
            //  -2
        }


    }
}
