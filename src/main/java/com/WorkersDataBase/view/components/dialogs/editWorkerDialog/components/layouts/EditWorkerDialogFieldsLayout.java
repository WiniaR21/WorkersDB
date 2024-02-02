package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.fields.EmailField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.fields.FirstNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.fields.LastNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.fields.PeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EditWorkerDialogFieldsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final Worker workerSelectedFromGrid;

    //  To configure
    FirstNameField firstNameField;
    LastNameField lastNameField;
    PeselField peselField;
    EmailField emailField;

    @Override
    public void configureComponents() {

        configureEmailField();
        configureFirstNameField();
        configureLastNameField();
        configurePeselField();
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
    private void configureEmailField(){
        emailField = new EmailField(
                workerSelectedFromGrid.getContact().getEmail()
        );
        emailField.configure();
    }
    private void configureFirstNameField(){
        firstNameField = new FirstNameField(
                workerSelectedFromGrid.getFirstName()
        );
        firstNameField.configure();
    }
    private void configureLastNameField(){
        lastNameField = new LastNameField(
                workerSelectedFromGrid.getLastName()
        );
        lastNameField.configure();
    }
    private void configurePeselField(){
        peselField = new PeselField(
                workerSelectedFromGrid.getPesel()
        );
        peselField.configure();
    }
}
