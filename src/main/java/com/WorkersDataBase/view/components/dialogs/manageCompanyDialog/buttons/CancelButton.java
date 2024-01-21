package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class CancelButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    public CancelButton(ManageCompanyDialog manageCompanyDialog) {
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        manageCompanyDialog.close();
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
