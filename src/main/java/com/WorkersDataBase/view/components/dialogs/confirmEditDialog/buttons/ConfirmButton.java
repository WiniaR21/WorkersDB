package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.ConfirmEditDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class ConfirmButton extends Button implements ComponentCreator, ButtonCreator {


    private final WorkersGrid workersGrid;
    private final WorkerService workerService;
    private final ConfirmEditDialog confirmEditDialog;
    private final Worker newWorker;
    public ConfirmButton(
            Worker newWorker,
            WorkersGrid workersGrid,
            WorkerService workerService,
            ConfirmEditDialog confirmEditDialog
    ) {
        this.newWorker = newWorker;
        this.workersGrid = workersGrid;
        this.workerService = workerService;
        this.confirmEditDialog = confirmEditDialog;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        workerService.addWorker(newWorker, true);
        workersGrid.refresh();
        confirmEditDialog.close();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Potwierdź");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickShortcut(Key.ENTER);
    }
}