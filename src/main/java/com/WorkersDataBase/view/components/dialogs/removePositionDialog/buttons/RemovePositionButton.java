package com.WorkersDataBase.view.components.dialogs.removePositionDialog.buttons;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final ComboBox<Position> positions;
    private final PositionService positionService;
    private final RemovePositionDialog removePositionDialog;

    @Override
    public void clickEvent() {
        boolean success = positionService.deletePosition(positions.getValue());
        if (success) removePositionDialog.close();
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
