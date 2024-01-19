package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H2;

public class EditHeader extends H2 implements ComponentCreator {
    public EditHeader() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {

        setText("Edytuj dane pracownika");
        getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
}
