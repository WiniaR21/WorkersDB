package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.buttons;


import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmFireButton extends Button implements ComponentCreator, ButtonCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final FireWorkerConfirmDialog fireWorkerConfirmDialog;
    @Override
    public void clickEvent() {
        Long idWorkerToFire = workerSelectedFromGrid.getId();

        boolean success = workerService.fireWorker(idWorkerToFire);
        if (success){
            workersGrid.refresh();
            fireWorkerConfirmDialog.close();
        }
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zwolnij");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_ERROR);
        addClickShortcut(Key.ENTER);
    }
}