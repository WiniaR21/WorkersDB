package com.WorkersDataBase.view.components.dialogs.removePositionDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class CloseRemovePositionDialog extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final RemovePositionDialog removePositionDialog;
    private final ManageCompanyDialog manageCompanyDialog;

    public CloseRemovePositionDialog(
            RemovePositionDialog removePositionDialog,
            ManageCompanyDialog manageCompanyDialog
    ) {
        this.removePositionDialog = removePositionDialog;
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        removePositionDialog.close();
        manageCompanyDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Cofnij");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
}
