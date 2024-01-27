package com.WorkersDataBase.dashboard;

import com.WorkersDataBase.dashboard.workersWithoutContractLayout.WorkersWithoutContractLayout;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@PageTitle("Statystyki")
@Route("statystyki")
@RequiredArgsConstructor
public class DashboardView extends VerticalLayout implements ComponentCreator {
    private final WorkerService workerService;
    //  To configure
    BackToMainViewButton backToMainViewButton;
    WorkersWithoutContractLayout workersWithoutContractLayout;

    @Override @PostConstruct
    public void configureComponents() {
        configureBackToMainViewButton();
        configureWorkersWithoutContractLayout();

        configureFront();
    }

    @Override
    public void configureFront() {
        add(
                new HorizontalLayout(backToMainViewButton),
                workersWithoutContractLayout
        );


    }
    private void configureBackToMainViewButton(){
        backToMainViewButton = new BackToMainViewButton();
        backToMainViewButton.configure();
    }
    private void configureWorkersWithoutContractLayout(){
        workersWithoutContractLayout = new WorkersWithoutContractLayout(workerService);
        workersWithoutContractLayout.configure();
    }
}
