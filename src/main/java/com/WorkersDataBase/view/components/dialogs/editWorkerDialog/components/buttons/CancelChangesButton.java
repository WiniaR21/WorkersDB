package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CancelChangesButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final EditWorkerDialog editWorkerDialog;

    @Override
    public void clickEvent() {
        editWorkerDialog.close();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Przerwij");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
