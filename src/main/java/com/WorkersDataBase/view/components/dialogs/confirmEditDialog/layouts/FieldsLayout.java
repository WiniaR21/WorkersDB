package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final Worker oryginalWorker;
    private final Worker newWorker;

    public FieldsLayout(Worker oryginalWorker, Worker newWorker) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;

        configureComponents();
        configureFront();
    }

    //  To configure
    WorkerDataField
            firstNameField, newFirstNameField,
            lastNameField, newLastnameField,
            peselField, newPeselField,
            contactField, newContactField;

    @Override
    public void configureComponents() {

        firstNameField = new WorkerDataField(
                oryginalWorker.getFirstName(), true
        );
        lastNameField = new WorkerDataField(
                oryginalWorker.getLastName(), true
        );
        peselField = new WorkerDataField(
                oryginalWorker.getPesel(), true
        );
        contactField = new WorkerDataField(
                oryginalWorker.getContact().getEmail(), true
        );


        newFirstNameField = new WorkerDataField(
               newWorker.getFirstName(), false
        );
        newLastnameField = new WorkerDataField(
                 newWorker.getLastName(), false
         );
        newPeselField = new WorkerDataField(
                newWorker.getPesel(), false
        );
        newContactField = new WorkerDataField(
                newWorker.getContact().getEmail(), false
        );
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setWidthFull();
        add(
                new HorizontalLayout(firstNameField, newFirstNameField),
                new HorizontalLayout(lastNameField, newLastnameField),
                new HorizontalLayout(peselField, newPeselField),
                new HorizontalLayout(contactField, newContactField)
        );
    }
}
