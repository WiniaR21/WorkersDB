package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.buttons;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import lombok.Setter;

@Setter
public class CloseDialogButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    AddWorkerDialog addWorkerDialog;
    WorkersGrid workersGrid;
    public CloseDialogButton(AddWorkerDialog addWorkerDialog, WorkersGrid workersGrid) {
        this.addWorkerDialog = addWorkerDialog;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        addWorkerDialog.close();
        workersGrid.refresh();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Strona główna");
        addClickShortcut(Key.ESCAPE);
        addClickListener(clickEvent -> clickEvent());


    }
}

