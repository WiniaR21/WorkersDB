package com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts;


import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SettingsDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    private final WorkersGrid workersGrid;

    //  To configure
    H3 header;
    CheckBoxLayout checkBoxLayout;
    SettingsDialogButtonsLayout settingsDialogButtonsLayout;

    @Override
    public void configureComponents() {
       configureHeader();
       configureCheckBoxLayout();
       configureSettingsDialogButtonLayout();
    }
    @Override
    public void configureFront() {
        add(
                header,
                checkBoxLayout,
                settingsDialogButtonsLayout
        );
    }
    private void configureHeader(){
        header = new H3("Ustawienia");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void configureCheckBoxLayout(){
        checkBoxLayout = new CheckBoxLayout();
        checkBoxLayout.configure();
    }
    private void configureSettingsDialogButtonLayout(){
        settingsDialogButtonsLayout = new SettingsDialogButtonsLayout(
                settingsDialog,
                workersGrid,
                checkBoxLayout
        );
        settingsDialogButtonsLayout.configure();
    }
}
