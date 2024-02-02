package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseConfirmEditDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final ConfirmEditDialog confirmEditDialog;
    private final EditWorkerDialog editWorkerDialog;

    @Override
    public void clickEvent() {
        confirmEditDialog.close();
        editWorkerDialog.open();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Zamknij");
        addClickShortcut(Key.ESCAPE);
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
}
