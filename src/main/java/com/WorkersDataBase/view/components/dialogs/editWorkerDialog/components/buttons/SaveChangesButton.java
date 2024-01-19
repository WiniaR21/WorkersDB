package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.FieldsLayout;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.Setter;

@Setter
public class SaveChangesButton extends Button implements ComponentCreator, ButtonCreator {
    // To inject by constructor
    private final WorkerService workerService;

    // To inject by setter
    Worker workerSelectedFromGrid;
    FieldsLayout fieldsLayout;
    WorkersGrid workersGrid;

    public SaveChangesButton(FieldsLayout fieldsLayout, WorkerService workerService) {
        this.fieldsLayout = fieldsLayout;
        this.workerService = workerService;

        configureComponents();
        configureFront();
    }

    @Override
    public void clickEvent() {
        workerSelectedFromGrid
                .setFirstName(fieldsLayout.getFirstNameField().getValue());

        workerSelectedFromGrid
                .setLastName(fieldsLayout.getLastNameField().getValue());

        workerSelectedFromGrid
                .setPesel(fieldsLayout.getPeselField().getValue());

        workerSelectedFromGrid.getContact()
                .setEmail(fieldsLayout.getEmailField().getValue());

        workerService.addWorker(workerSelectedFromGrid);

        workersGrid.refresh();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Zapisz");
        addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addClickListener(buttonClickEvent -> clickEvent());
    }

}
