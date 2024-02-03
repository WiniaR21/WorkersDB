package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionDeleteService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons.CloseRemovePositionDialogButton;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialogButtonsLayout
        extends HorizontalLayout
        implements ComponentCreator
{
    //  Components
    private final RemovePositionDialog removePositionDialog;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ComboBox<Position> positions;
    private final ServicePushNotification notification;
    //  Services
    private final PositionDeleteService positionDeleteService;

    //  To configure
    RemovePositionButton removePositionButton;
    CloseRemovePositionDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setRemovePositionButton();
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        add(
                removePositionButton,
                closeDialogButton
        );
    }

    private void setRemovePositionButton() {
        removePositionButton = new RemovePositionButton(
                notification,
                positions,
                removePositionDialog,
                positionDeleteService
        );
        removePositionButton.configure();
    }

    private void setCloseDialogButton() {
        closeDialogButton = new CloseRemovePositionDialogButton(
                removePositionDialog,
                manageCompanyDialog
        );
        closeDialogButton.configure();
    }
}
