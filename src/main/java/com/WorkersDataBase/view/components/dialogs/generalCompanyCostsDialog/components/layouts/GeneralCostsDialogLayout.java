package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.GeneralCostsDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final GeneralCostsDialog generalCostsDialog;
    private final DashboardDialog dashboardDialog;
    //  Services
    private final CompanyFeeGetService companyFeeGetService;
    //  To configure
    GeneralCostsDialogFieldsLayout fieldsLayout;
    GeneralCostsDialogButtonsLayout buttonsLayout;
    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
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
    @Override
    public void configureHeader() {
        header = new H3("Suma kosztów");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }

    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new GeneralCostsDialogFieldsLayout(
                companyFeeGetService);
        fieldsLayout.configure();
    }

    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new GeneralCostsDialogButtonsLayout(
                generalCostsDialog,
                dashboardDialog
        );
        buttonsLayout.configure();
    }
}
