package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.EmailField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.FirstNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.LastNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.PeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    private final Worker workerSelectedFromGrid;
    public FieldsLayout(Worker workerSelectedFromGrid) {
        this.workerSelectedFromGrid = workerSelectedFromGrid;

        configureComponents();
        configureFront();
    }

    //  To configure
    FirstNameField firstNameField;
    LastNameField lastNameField;
    PeselField peselField;
    EmailField emailField;

    @Override
    public void configureComponents() {

        emailField = new EmailField(
                workerSelectedFromGrid.getContact().getEmail()
        );

        firstNameField = new FirstNameField(
                workerSelectedFromGrid.getFirstName()
        );

        lastNameField = new LastNameField(
                workerSelectedFromGrid.getLastName()
        );

        peselField = new PeselField(
                workerSelectedFromGrid.getPesel()
        );
    }

    @Override
    public void configureFront() {
        add(
                firstNameField,
                lastNameField,
                peselField,
                emailField
        );
    }
}
