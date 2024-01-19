package com.WorkersDataBase.service.dialogs.layouts;

import com.WorkersDataBase.service.dialogs.textfields.ContactField;
import com.WorkersDataBase.service.dialogs.textfields.FirstNameField;
import com.WorkersDataBase.service.dialogs.textfields.LastNameField;
import com.WorkersDataBase.service.dialogs.textfields.PeselField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    FirstNameField firstNameField;
    LastNameField lastNameField;
    PeselField peselField;
    ContactField contactField;

    public FieldsLayout() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        firstNameField = new FirstNameField();
        lastNameField = new LastNameField();
        peselField = new PeselField();
        contactField = new ContactField();
    }

    @Override
    public void configureFront() {
        add(
                firstNameField,
                lastNameField,
                peselField,
                contactField
        );
    }
}
