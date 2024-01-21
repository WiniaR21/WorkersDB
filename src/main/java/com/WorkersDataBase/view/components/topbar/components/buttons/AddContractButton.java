package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class AddContractButton extends Button implements ComponentCreator, ButtonCreator {
    private final PositionService positionService;
    public AddContractButton(PositionService positionService) {
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        new ManageCompanyDialog(positionService);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zarządzaj firmą");
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        addClickListener(clickEvent -> clickEvent());
    }
}
