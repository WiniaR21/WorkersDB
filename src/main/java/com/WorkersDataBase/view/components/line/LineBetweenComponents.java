package com.WorkersDataBase.view.components.line;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LineBetweenComponents extends HorizontalLayout implements ComponentCreator {
    public LineBetweenComponents() {
        configureFront();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setWidthFull();
        getStyle().set("background-color", "#576b85");
        setHeight("2px");
        setClassName("header-line");
        setPadding(false);
    }
}
