package com.WorkersDataBase.view.components.dialogs.settingsDialog.components.layouts;


import com.WorkersDataBase.view.components.dialogs.settingsDialog.SettingsDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SettingsDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final SettingsDialog settingsDialog;
    private final WorkersGrid workersGrid;

    //  To configure
    H3 header;
    SettingsDialogCheckBoxLayout checkBoxLayout;
    SettingsDialogButtonsLayout settingsDialogButtonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        add(
                header,
                checkBoxLayout,
                settingsDialogButtonsLayout
        );
    }
    @Override
    public void configureHeader(){
        header = new H3("Ustawienia");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        checkBoxLayout = new SettingsDialogCheckBoxLayout();
        checkBoxLayout.configure();
    }
    @Override
    public void configureButtonsLayout() {
        settingsDialogButtonsLayout = new SettingsDialogButtonsLayout(
                settingsDialog,
                workersGrid,
                checkBoxLayout
        );
        settingsDialogButtonsLayout.configure();
    }
}
