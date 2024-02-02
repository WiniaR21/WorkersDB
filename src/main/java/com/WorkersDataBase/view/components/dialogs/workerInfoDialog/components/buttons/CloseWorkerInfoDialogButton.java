package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.buttons;

import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloseWorkerInfoDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    private final WorkerInfoDialog workerInfoDialog;

    @Override
    public void clickEvent() {
        workerInfoDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setAriaLabel("");
        setText("Cofnij");
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickListener(buttonClickEvent -> clickEvent());

    }
}
