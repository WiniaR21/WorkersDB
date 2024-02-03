package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.layouts;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.service.position.PositionPostService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.AddNewPositionButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.CloseManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageCompanyDialogButtonsLayout
        extends VerticalLayout
        implements ComponentCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final ManageCompanyDialog       manageCompanyDialog;
    //  Services
    private final PositionPostService       positionPostService;
    private final PositionGetService        positionGetService;
    private final PositionDeleteService     positionDeleteService;

                //  To configure
                AddNewPositionButton        addNewPositionButton;
                RemovePositionButton        removePositionButton;
                CloseManageCompanyDialog    closeDialogButton;
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
                positionPostService,
                notification
        );
        addNewPositionButton.configure();
    }
    private void setRemovePositionButton() {
        removePositionButton = new RemovePositionButton(
                notification,
                manageCompanyDialog,
                positionGetService,
                positionDeleteService
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
