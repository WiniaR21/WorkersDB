package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons.CloseRemovePositionDialogButton;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final RemovePositionDialog removePositionDialog;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;
    private final ComboBox<Position> positions;
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
                positions,
                positionService,
                removePositionDialog,
                notification
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
