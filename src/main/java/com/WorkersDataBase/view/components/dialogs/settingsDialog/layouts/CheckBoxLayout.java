package com.WorkersDataBase.view.components.dialogs.settingsDialog.layouts;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
@Getter
public class CheckBoxLayout extends VerticalLayout implements ComponentCreator {
    //To configure
    CheckboxGroup<String> checkBox;
    Set<String> checkBoxValue;
    public CheckBoxLayout() {

        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        checkBoxValue = new HashSet<>();

        checkBox = new CheckboxGroup<>();
        checkBox.setLabel("Widok danych");
        checkBox.setItems("Imie", "Nazwisko", "PESEL", "Email");
        checkBox.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        checkBox.addValueChangeListener(valuesCheckedByUser -> checkBoxValue = valuesCheckedByUser.getValue());
    }

    @Override
    public void configureFront() {
        setSpacing(false);
        setPadding(false);
        add(checkBox);
    }
}
