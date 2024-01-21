package com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    private final WriteContractDialog writeContractDialog;
    public WritteContractButton(WriteContractDialog writeContractDialog) {
        this.writeContractDialog = writeContractDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        writeContractDialog.close();

    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zatwierdź");
        addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        addClickListener(e -> clickEvent());
    }
}
