package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.CancelChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.SaveChangesButton;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons.WritteContractButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ButtonsLayout extends HorizontalLayout implements ComponentCreator {
    SaveChangesButton saveChangesButton;
    CancelChangesButton cancelChangesButton;
    WritteContractButton writteContractButton;

    public ButtonsLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        saveChangesButton = new SaveChangesButton();
        cancelChangesButton = new CancelChangesButton();
        writteContractButton = new WritteContractButton();
    }

    @Override
    public void configureFront() {
        add(
                saveChangesButton,
                cancelChangesButton,
                writteContractButton
        );
    }
}
