package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CancelNewPositionTypeDialog extends Button implements ComponentCreator, ButtonCreator {

    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final ManageCompanyDialog manageCompanyDialog;

    @Override
    public void clickEvent() {
        newPositionTypeDialog.close();
        manageCompanyDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Cofnij");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
}
