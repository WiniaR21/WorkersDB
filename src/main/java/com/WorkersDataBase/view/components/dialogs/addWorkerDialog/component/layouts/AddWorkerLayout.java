package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.HeadlineAddWorker;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddWorkerLayout extends VerticalLayout implements ComponentCreator {
    HeadlineAddWorker headlineAddWorker;
    FieldsLayout fieldsLayout;
    ButtonsLayoutWorkerDialog buttonsLayout;
    public AddWorkerLayout(HeadlineAddWorker headlineAddWorker, FieldsLayout fieldsLayout, ButtonsLayoutWorkerDialog buttonsLayout) {
        this.headlineAddWorker = headlineAddWorker;
        this.fieldsLayout = fieldsLayout;
        this.buttonsLayout = buttonsLayout;

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront(){
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
        getStyle().set("width", "300px").set("max-width", "100%");
        add(
                headlineAddWorker,
                fieldsLayout,
                buttonsLayout
        );
    }
}
