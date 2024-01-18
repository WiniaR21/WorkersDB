package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersEmailField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersFirstNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersLastNameField;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.dataEntryFields.WorkersPeselField;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class FieldsLayout extends VerticalLayout implements ComponentCreator {
    WorkersFirstNameField workersFirstNameField;
    WorkersLastNameField workersLastNameField;
    WorkersEmailField workersEmailField;
    WorkersPeselField workersPeselField;
    public FieldsLayout( ) {
        configureComponents();
        configureFront();
    }
    @Override
    public void configureComponents(){
        workersFirstNameField = new WorkersFirstNameField();
        workersLastNameField = new WorkersLastNameField();
        workersEmailField = new WorkersEmailField();
        workersPeselField = new WorkersPeselField();
    }
    @Override
    public void configureFront(){
        setAlignItems(Alignment.CENTER);
        setSpacing(false);
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
        add(
                workersFirstNameField,
                workersLastNameField,
                workersEmailField,
                workersPeselField
        );
    }
}
