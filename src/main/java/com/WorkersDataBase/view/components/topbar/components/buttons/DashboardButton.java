package com.WorkersDataBase.view.components.topbar.components.buttons;

import com.WorkersDataBase.service.companyFee.CompanyFeeGetService;
import com.WorkersDataBase.service.contract.ContractGetService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.workersFee.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DashboardButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    //  To inject by constructor
    //  Services
    private final ContractGetService    contractGetService;
    private final WorkerGetService      workerGetService;
    private final CompanyFeeGetService  companyFeeGetService;
    private final WorkersFeeGetService  workersFeeGetService;

    @Override
    public void clickEvent() {
        DashboardDialog dashboardDialog = new DashboardDialog(
                contractGetService,
                workerGetService,
                companyFeeGetService,
                workersFeeGetService
        );
        dashboardDialog.configure();
    }
    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront() {
        setText("Statystyki");
        addClickListener(clickEvent -> clickEvent());
        addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    }
}
