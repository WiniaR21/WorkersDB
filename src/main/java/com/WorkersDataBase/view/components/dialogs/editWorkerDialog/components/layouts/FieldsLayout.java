package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.EmailField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.FirstNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.LastNameField;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.textfields.PeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    FirstNameField firstNameField;
    LastNameField lastNameField;
    PeselField peselField;
    EmailField emailField;

    public FieldsLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        emailField = new EmailField();
        firstNameField = new FirstNameField();
        lastNameField = new LastNameField();
        peselField = new PeselField();
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
