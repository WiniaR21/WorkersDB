package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.CloseNewPositionTypeDialogButton;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.SaveNewPositionType;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.fields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NewPositionTypeDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;
    private final PositionNameField positionNameField;

    //  To configure
    SaveNewPositionType saveNewPositionType;
    CloseNewPositionTypeDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setSaveNewPositionType();
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        add(
                saveNewPositionType,
                closeDialogButton
        );
    }

    private void setSaveNewPositionType() {
        saveNewPositionType = new SaveNewPositionType(
                positionNameField,
                positionService,
                newPositionTypeDialog,
                notification
        );
        saveNewPositionType.configure();
    }

    private void setCloseDialogButton() {
        closeDialogButton = new CloseNewPositionTypeDialogButton(
                newPositionTypeDialog,
                manageCompanyDialog
        );
        closeDialogButton.configure();
    }
}
