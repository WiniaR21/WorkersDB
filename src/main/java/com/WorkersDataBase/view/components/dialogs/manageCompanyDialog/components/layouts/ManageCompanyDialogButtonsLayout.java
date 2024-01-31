package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.AddNewPositionButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.CloseManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageCompanyDialogButtonsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;
    private final ServicePushNotification notification;

    //  To configure
    AddNewPositionButton addNewPositionButton;
    RemovePositionButton removePositionButton;
    CloseManageCompanyDialog closeDialogButton;
    @Override
    public void configureComponents() {
        setAddNewPositionButton();
        setRemovePositionButton();
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        add(
                addNewPositionButton,
                removePositionButton,
                closeDialogButton
        );
    }
    private void setAddNewPositionButton() {
        addNewPositionButton = new AddNewPositionButton(
                manageCompanyDialog,
                positionService,
                notification
        );
        addNewPositionButton.configure();
    }
    private void setRemovePositionButton() {
        removePositionButton = new RemovePositionButton(
                positionService,
                manageCompanyDialog,
                notification
        );
        removePositionButton.configure();
    }
    private void setCloseDialogButton() {
        closeDialogButton = new CloseManageCompanyDialog(
                manageCompanyDialog
        );
        closeDialogButton.configure();
    }
}
