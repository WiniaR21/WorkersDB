package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    FirstNameFieldNew firstNameFieldNew;
    LastNameFieldNew lastNameFieldNew;
    PeselFieldNew peselFieldNew;
    ContactFieldNew contactFieldNew;



    public FieldsLayout(Worker oryginalWorker, Worker newWorker) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

        firstNameField = new FirstNameField(
                oryginalWorker.getFirstName()
        );
        lastNameField = new LastNameField(
                oryginalWorker.getLastName()
        );
        peselField = new PeselField(
                oryginalWorker.getPesel()
        );
        contactField = new ContactField(
                oryginalWorker.getContact().getEmail()
        );


        firstNameFieldNew = new FirstNameFieldNew(
                newWorker.getFirstName()
        );
        lastNameFieldNew = new LastNameFieldNew(
                newWorker.getLastName()
        );
        peselFieldNew = new PeselFieldNew(
                newWorker.getPesel()
        );
        contactFieldNew = new ContactFieldNew(
                newWorker.getContact().getEmail()
        );
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setWidthFull();
        add(
                new HorizontalLayout(firstNameField, firstNameFieldNew),
                new HorizontalLayout(lastNameField, lastNameFieldNew),
                new HorizontalLayout(peselField, peselFieldNew),
                new HorizontalLayout(contactField, contactFieldNew)

        );
    }
}
