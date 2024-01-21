package com.WorkersDataBase.view.components.dialogs.removePositionDialog.buttons;

import com.WorkersDataBase.data.contract.Position;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;

public class RemovePositionButton extends Button implements ComponentCreator, ButtonCreator {
    private final ComboBox<Position> positions;
    private final PositionService positionService;
    public RemovePositionButton(
            ComboBox<Position> positions,
            PositionService positionService
    ) {
        this.positions = positions;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        positionService.deletePosition(positions.getValue());
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Usuń");
        addThemeVariants(ButtonVariant.LUMO_ERROR);
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
