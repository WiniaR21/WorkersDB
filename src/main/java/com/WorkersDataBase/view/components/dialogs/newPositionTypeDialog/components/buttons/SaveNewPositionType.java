package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;


public class SaveNewPositionType extends Button implements ComponentCreator, ButtonCreator {
    private final PositionNameField positionNameField;
    private final PositionService positionService;
    public SaveNewPositionType(PositionNameField positionNameField, PositionService positionService) {
        this.positionNameField = positionNameField;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        String positionName = positionNameField.getValue();
        positionService.addNewPositionType(positionName);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zapisz");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    }
}
