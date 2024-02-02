package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class CloseAddWorkerDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final AddWorkerDialog addWorkerDialog;

    @Override
    public void clickEvent() {
        addWorkerDialog.close();
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

