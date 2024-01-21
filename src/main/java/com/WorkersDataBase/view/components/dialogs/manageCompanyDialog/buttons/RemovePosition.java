package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class RemovePosition extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    public RemovePosition(
            PositionService positionService,
            ManageCompanyDialog manageCompanyDialog
    ) {
        this.positionService = positionService;
        this.manageCompanyDialog = manageCompanyDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        manageCompanyDialog.close();
        new RemovePositionDialog(positionService, manageCompanyDialog);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Usuń rodzaj stanowiska");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
