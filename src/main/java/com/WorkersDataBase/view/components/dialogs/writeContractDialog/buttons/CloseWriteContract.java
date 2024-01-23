package com.WorkersDataBase.view.components.dialogs.writeContractDialog.buttons;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class CloseWriteContract extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final EditWorkerDialog editWorkerDialog;

    public CloseWriteContract(
            WriteContractDialog writeContractDialog,
            EditWorkerDialog editWorkerDialog
    ) {
        this.writeContractDialog = writeContractDialog;
        this.editWorkerDialog = editWorkerDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        writeContractDialog.close();
        editWorkerDialog.open();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Cofnij");
        addClickListener(e -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
}