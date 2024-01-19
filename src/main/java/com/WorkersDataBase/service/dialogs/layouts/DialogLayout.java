package com.WorkersDataBase.service.dialogs.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout implements ComponentCreator {

    //  To configure
    FieldsLayout fieldsLayout;
    ButtonsLayout buttonsLayout;

    //  To inject by constructor
    Worker oryginalWorker;
    Worker newWorker;

    public DialogLayout(Worker oryginalWorker, Worker newWorker) {
        this.oryginalWorker = oryginalWorker;
        this.newWorker = newWorker;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

        fieldsLayout = new FieldsLayout(
                oryginalWorker,
                newWorker
        );

        buttonsLayout = new ButtonsLayout();
    }

    @Override
    public void configureFront() {
        add(
                fieldsLayout,
                buttonsLayout
        );
    }
}
