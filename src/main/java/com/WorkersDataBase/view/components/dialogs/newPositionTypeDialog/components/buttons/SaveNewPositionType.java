package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;


public class SaveNewPositionType extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final PositionNameField positionNameField;
    private final PositionService positionService;
    private final NewPositionTypeDialog newPositionTypeDialog;

    public SaveNewPositionType(
            PositionNameField positionNameField,
            PositionService positionService,
            NewPositionTypeDialog newPositionTypeDialog
    ) {
        this.positionNameField = positionNameField;
        this.positionService = positionService;
        this.newPositionTypeDialog = newPositionTypeDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        String positionName = positionNameField.getValue();

        boolean success = positionService.addNewPositionType(positionName);
        if(success) newPositionTypeDialog.close();
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
