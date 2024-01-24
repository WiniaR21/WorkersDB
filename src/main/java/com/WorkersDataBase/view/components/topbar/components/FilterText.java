package com.WorkersDataBase.view.components.topbar.components;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FilterText extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final WorkersGrid grid;

    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront() {
        setClassName("search-text");
        setPlaceholder("Szukaj po nazwisku...");
        setClearButtonVisible(true);
        setValueChangeMode(ValueChangeMode.EAGER);
        getStyle().set("color", "#eaf0f8");
    }
}
