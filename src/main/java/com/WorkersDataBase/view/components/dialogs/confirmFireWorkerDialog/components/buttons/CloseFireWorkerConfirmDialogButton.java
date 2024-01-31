package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseFireWorkerConfirmDialogButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final FireWorkerConfirmDialog fireWorkerConfirmDialog;
    private final EditWorkerDialog editWorkerDialog;
    @Override
    public void clickEvent() {
        fireWorkerConfirmDialog.close();
        editWorkerDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Cofnij");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ESCAPE);
    }
}
