package com.WorkersDataBase.service.dialogs.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.dialogs.textfields.ContactField;
import com.WorkersDataBase.service.dialogs.textfields.FirstNameField;
import com.WorkersDataBase.service.dialogs.textfields.LastNameField;
import com.WorkersDataBase.service.dialogs.textfields.PeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    Worker oryginalWorker;
    Worker newWorker;

    //  To configure
    FirstNameField firstNameField;
    LastNameField lastNameField;
    PeselField peselField;
    ContactField contactField;



    public FieldsLayout(Worker oryginalWorker, Worker newWorker) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

        firstNameField = new FirstNameField(
                oryginalWorker.getFirstName(),
                newWorker.getFirstName()
        );

        lastNameField = new LastNameField(
                oryginalWorker.getLastName(),
                newWorker.getLastName()
        );

        peselField = new PeselField(
                oryginalWorker.getPesel(),
                newWorker.getPesel()
        );

        contactField = new ContactField(
                oryginalWorker.getContact().getEmail(),
                newWorker.getContact().getEmail()
        );
    }

    @Override
    public void configureFront() {
        add(
                firstNameField,
                lastNameField,
                peselField
        );
    }
}
