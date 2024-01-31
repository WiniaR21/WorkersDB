package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.fields.WorkersPeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class AddWorkerDialogFieldsLayout extends VerticalLayout implements ComponentCreator {
    //  TO configure
    WorkersFirstNameField firstNameField;
    WorkersLastNameField lastNameField;
    WorkersEmailField emailField;
    WorkersPeselField peselField;
    @Override
    public void configureComponents() {
        setFirstNameField();
        setLastNameField();
        setEmailField();
        setPeselField();
    }
    @Override
    public void configureFront() {
        add(
                firstNameField,
                lastNameField,
                emailField,
                peselField
        );

        setAlignItems(Alignment.CENTER);
        setSpacing(false);
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
    }
    private void setFirstNameField() {
        firstNameField = new WorkersFirstNameField();
        firstNameField.configure();
    }
    private void setLastNameField() {
        lastNameField = new WorkersLastNameField();
        lastNameField.configure();
    }
    private void setEmailField() {
        emailField = new WorkersEmailField();
        emailField.configure();
    }
    private void setPeselField() {
        peselField = new WorkersPeselField();
        peselField.configure();
    }
}
