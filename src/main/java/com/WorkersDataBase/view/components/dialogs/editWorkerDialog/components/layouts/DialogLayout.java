package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts;

import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.EditHeader;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class DialogLayout extends VerticalLayout implements ComponentCreator {

    //  To inject by constructor
    private final WorkerService workerService;

    //  To configure
    EditHeader editHeader;
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;
    public DialogLayout(WorkerService workerService) {
        this.workerService = workerService;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        editHeader = new EditHeader();
        fieldsLayout = new FieldsLayout();
        buttonsLayout = new ButtonsLayout(fieldsLayout,workerService);
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        add(
                editHeader,
                fieldsLayout,
                buttonsLayout
        );
    }
}
