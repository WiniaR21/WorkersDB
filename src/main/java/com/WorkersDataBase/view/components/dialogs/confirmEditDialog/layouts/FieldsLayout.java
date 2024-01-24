package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FieldsLayout extends VerticalLayout implements ComponentCreator {

    //  To inject by constructor
    private final Worker oryginalWorker;
    private final Worker newWorker;

    //  To configure
    WorkerDataField
            firstNameField, newFirstNameField,
            lastNameField, newLastnameField,
            peselField, newPeselField,
            contactField, newContactField;

    @Override
    public void configureComponents() {
        configureOryginalFields();
        configureNewFields();
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

    private void configureOryginalFields(){

        firstNameField = new WorkerDataField(
                oryginalWorker.getFirstName(), true
        );  firstNameField.configure();


        lastNameField = new WorkerDataField(
                oryginalWorker.getLastName(), true
        );  lastNameField.configure();

        peselField = new WorkerDataField(
                oryginalWorker.getPesel(), true
        );  peselField.configure();

        contactField = new WorkerDataField(
                oryginalWorker.getContact().getEmail(), true
        );  contactField.configure();

        firstNameField.setLabel("Imie");
        lastNameField.setLabel("Nazwisko");
        peselField.setLabel("PESEL");
        contactField.setLabel("Email");
    }

    private void configureNewFields(){
        newFirstNameField = new WorkerDataField(
                newWorker.getFirstName(), false
        );  newFirstNameField.configure();

        newLastnameField = new WorkerDataField(
                newWorker.getLastName(), false
        );  newLastnameField.configure();

        newPeselField = new WorkerDataField(
                newWorker.getPesel(), false
        );  newPeselField.configure();

        newContactField = new WorkerDataField(
                newWorker.getContact().getEmail(), false
        );  newContactField.configure();


        newFirstNameField.setLabel("Imie");
        newLastnameField.setLabel("Nazwisko");
        newPeselField.setLabel("PESEL");
        newContactField.setLabel("Email");
    }
}
