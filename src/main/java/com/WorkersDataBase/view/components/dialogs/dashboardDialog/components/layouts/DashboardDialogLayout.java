package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.layouts;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    //  Services
    private final ContractGetService contractGetService;
    private final WorkerGetService workerGetService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;
    //  To configure
    DashboardDialogButtonsLayout buttonsLayout;
    H3 header;

    @Override
    public void configureComponents() {
        configureButtonsLayout();
        configureHeader();
    }
    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader() {
        header = new H3("Statystyki");
        header.getStyle()
                //.set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {}
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new DashboardDialogButtonsLayout(
                dashboardDialog,
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        buttonsLayout.configure();
    }
}
