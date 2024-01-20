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
    private final Worker workerOriginal;
    public FieldsLayout(Worker workerOriginal) {
        this.workerOriginal = workerOriginal;

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
                workerOriginal.getContact().getEmail()
        );

        firstNameField = new FirstNameField(
                workerOriginal.getFirstName()
        );

        lastNameField = new LastNameField(
                workerOriginal.getLastName()
        );

        peselField = new PeselField(
                workerOriginal.getPesel()
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
