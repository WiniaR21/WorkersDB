package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;

public class WritteContractButton extends Button implements ComponentCreator, ButtonCreator {
    private final PositionService positionService;
    private final Worker worker;
    public WritteContractButton(
            PositionService positionService,
            Worker worker
    ) {
        this.positionService = positionService;
        this.worker = worker;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        new WriteContractDialog(positionService, worker);
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Daj umowę");
        addClickListener(buttonClickEvent -> clickEvent());
    }
}
