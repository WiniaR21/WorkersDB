package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class AddNewPositionButton extends Button implements ComponentCreator ,ButtonCreator {
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;

    public AddNewPositionButton(
            ManageCompanyDialog manageCompanyDialog,
            PositionService positionService
    ) {
        this.manageCompanyDialog = manageCompanyDialog;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        manageCompanyDialog.close();
        new NewPositionTypeDialog(positionService, manageCompanyDialog);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Nowy rodzaj stanowiska");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
