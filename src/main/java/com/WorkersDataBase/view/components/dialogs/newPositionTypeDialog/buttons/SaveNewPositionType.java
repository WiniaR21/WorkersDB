package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.buttons;

import com.WorkersDataBase.service.contract.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;


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
    }
}
