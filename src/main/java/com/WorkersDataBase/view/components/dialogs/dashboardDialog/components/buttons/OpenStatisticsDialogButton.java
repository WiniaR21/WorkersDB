package com.WorkersDataBase.view.components.dialogs.dashboardDialog.components.buttons;

import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.service.getService.ContractGetService;
import com.WorkersDataBase.service.getService.WorkerGetService;
import com.WorkersDataBase.service.getService.WorkersFeeGetService;
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
    //  Services
    private final WorkerGetService workerGetService;
    private final ContractGetService contractGetService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;

    @Override
    public void clickEvent() {
        StatisticDialog statisticDialog = new StatisticDialog(
                dashboardDialog,
                workerGetService,
                contractGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        statisticDialog.configure();
    }
    @Override
    public void configureComponents() {}
    @Override
    public void configureFront() {
        setText("Średnie w firmie");
        addClickListener(buttonClickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}