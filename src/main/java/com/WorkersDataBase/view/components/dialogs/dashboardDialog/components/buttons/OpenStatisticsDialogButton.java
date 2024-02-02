package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OpenStatisticsDialogButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    private final DashboardDialog dashboardDialog;
    private final WorkerService workerService;
    private final ContractService contractService;
    private final CompanyFeeGetService companyFeeGetService;
    @Override
    public void clickEvent() {
        StatisticDialog statisticDialog = new StatisticDialog(
                dashboardDialog,
                workerService,
                contractService,
                companyFeeGetService
        );
        statisticDialog.configure();
    }

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Średnie w firmie");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}