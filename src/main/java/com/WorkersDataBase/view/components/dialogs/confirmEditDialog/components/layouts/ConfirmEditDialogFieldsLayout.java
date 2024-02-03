package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.confirmEditDialog.components.fields.WorkerDataField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmEditDialogFieldsLayout extends VerticalLayout implements ComponentCreator {
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
        setFirstNameField();
        setLastNameField();
        setPeselField();
        setContactField();
        setNewFirstNameField();
        setNewLastNameField();
        setNewPeselField();
        setNewContactField();
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
    private void setFirstNameField() {
        firstNameField = new WorkerDataField(
                oryginalWorker.getFirstName(), true
        );
        firstNameField.configure();
        firstNameField.setLabel("Imie");
    }
    private void setNewFirstNameField() {
        newFirstNameField = new WorkerDataField(
                newWorker.getFirstName(), false
        );
        newFirstNameField.configure();
        newFirstNameField.setLabel("Imie");
    }
    private void setLastNameField() {
        lastNameField = new WorkerDataField(
                oryginalWorker.getLastName(), true
        );
        lastNameField.configure();
        lastNameField.setLabel("Nazwisko");
    }
    private void setNewLastNameField() {
        newLastnameField = new WorkerDataField(
                newWorker.getLastName(), false
        );
        newLastnameField.configure();
        newLastnameField.setLabel("Nazwisko");
    }
    private void setPeselField() {
        peselField = new WorkerDataField(
                oryginalWorker.getPersonalNumber(), true
        );
        peselField.configure();
        peselField.setLabel("PESEL");
    }
    private void setNewPeselField() {
        newPeselField = new WorkerDataField(
                newWorker.getPersonalNumber(), false
        );
        newPeselField.configure();
        newPeselField.setLabel("PESEL");
    }
    private void setContactField() {
        contactField = new WorkerDataField(
                oryginalWorker.getContact().getEmail(), true
        );
        contactField.configure();
        contactField.setLabel("Email");
    }
    private void setNewContactField() {
        newContactField = new WorkerDataField(
                newWorker.getContact().getEmail(), false
        );
        newContactField.configure();
        newContactField.setLabel("Email");
    }
}
