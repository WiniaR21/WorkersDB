package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final GeneralCostsDialog generalCostsDialog;
    private final DashboardDialog dashboardDialog;

    //  To configure
    GeneralCostsDialogFieldsLayout fieldsLayout;
    GeneralCostsDialogButtonsLayout buttonsLayout;
    @Override
    public void configureComponents() {
        setHeader();
        setFieldsLayout();
        setButtonsLayout();
    }
    H3 header;
    @Override
    public void configureFront() {

        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }

    private void setHeader(){
        header = new H3("Suma kosztów");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void setFieldsLayout() {
        fieldsLayout = new GeneralCostsDialogFieldsLayout();
        fieldsLayout.configure();
    }
    private void setButtonsLayout(){
        buttonsLayout = new GeneralCostsDialogButtonsLayout(
                generalCostsDialog,
                dashboardDialog
        );
        buttonsLayout.configure();
    }
}
