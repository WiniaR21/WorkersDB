package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
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
    //  To inject by constructor
    private final ComboBox<Position> positions;
    private final PositionService positionService;
    private final RemovePositionDialog removePositionDialog;
    private final ServicePushNotification notification;

    @Override
    public void clickEvent() {
        int status = positionService.deletePosition(getPositionFromUser());
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
        if (status ==  0) notification.pushDeletePositionSuccess(getPositionFromUser());
        if (status == -1) notification.pushUserTryingAddNullPositionInfo();
        if (status == -2) notification.pushDeletingPositionConflictInfo();

        if (status ==  0) removePositionDialog.close();
    }
}
