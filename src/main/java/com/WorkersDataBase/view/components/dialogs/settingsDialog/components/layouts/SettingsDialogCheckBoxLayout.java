package com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts;


import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@RequiredArgsConstructor
public class SettingsDialogCheckBoxLayout extends VerticalLayout implements ComponentCreator {
    //To configure
    Checkbox showAllCheckbox;
    CheckboxGroup<String> checkBoxOfDataToShow;
    Set<String> checkBoxValue;
    List<String> checkBoxPossibleOptions;

    @Override
    public void configureComponents() {
        configurePossibleOptions();
        configureShowAllCheckbox();
        configureCheckBoxOfDataToShow();
    }
    @Override
    public void configureFront() {
        setSpacing(false);
        setPadding(false);
        add(
                showAllCheckbox,
                checkBoxOfDataToShow
        );
    }
    private void configurePossibleOptions(){
        checkBoxPossibleOptions = List.of(
                "Imie",
                "Nazwisko",
                "PESEL",
                "Email",
                "Stanowisko",
                "Wynagrodzenie",
                "Płeć",
                "Data urodzenia",
                "Wiek"
        );
    }
    private void configureShowAllCheckbox(){
        showAllCheckbox = new Checkbox();
        showAllCheckbox.setLabel("Wszystkie dane");
        showAllCheckbox.addValueChangeListener(event -> {
            if (showAllCheckbox.getValue()){
                checkBoxPossibleOptions.forEach(option -> checkBoxOfDataToShow.select(option));
            }
            else checkBoxOfDataToShow.deselectAll();
        });
    }
    private void configureCheckBoxOfDataToShow(){
        checkBoxValue = new HashSet<>();
        checkBoxOfDataToShow = new CheckboxGroup<>();
        checkBoxOfDataToShow.setLabel("Widok danych");
        configureCheckBoxOptions();
        checkBoxOfDataToShow.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        checkBoxOfDataToShow.addValueChangeListener(valuesCheckedByUser -> checkBoxValue = valuesCheckedByUser.getValue());
    }
    private void configureCheckBoxOptions(){
        checkBoxOfDataToShow.setItems(
                checkBoxPossibleOptions
        );
    }
}
