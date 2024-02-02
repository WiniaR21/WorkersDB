package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticsDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final StatisticDialog statisticDialog;
    private final DashboardDialog dashboardDialog;
    private final WorkerService workerService;
    private final ContractService contractService;
    private final CompanyFeeGetService companyFeeGetService;

    //  To configure
    H3 header;
    StatisticDialogFieldsLayout fieldsLayout;
    StatisticDialogButtonsLayout buttonsLayout;
    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader() {
        header = new H3("Średnie w firmie");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new StatisticDialogFieldsLayout(
                workerService,
                contractService,
                companyFeeGetService
        );
        fieldsLayout.configure();
    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new StatisticDialogButtonsLayout(
                statisticDialog,
                dashboardDialog
        );
        buttonsLayout.configure();
    }
}
