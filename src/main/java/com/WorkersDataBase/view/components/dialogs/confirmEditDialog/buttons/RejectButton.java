package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RejectButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final ConfirmEditDialog confirmEditDialog;

    @Override
    public void clickEvent() {
        confirmEditDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Odrzuć");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
