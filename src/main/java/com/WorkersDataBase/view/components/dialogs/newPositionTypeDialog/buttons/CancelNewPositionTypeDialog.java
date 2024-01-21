package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class CancelNewPositionTypeDialog extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    public CancelNewPositionTypeDialog(NewPositionTypeDialog newPositionTypeDialog) {
        this.newPositionTypeDialog = newPositionTypeDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        newPositionTypeDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Cofnij");
        addClickListener(e -> clickEvent());
    }
}
