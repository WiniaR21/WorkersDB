package com.WorkersDataBase.dashboard.workersWithoutContractLayout;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkersWithoutContractLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    //  To configure
    Grid<Worker> workersWithoutContractGrid;

    @Override
    public void configureComponents() {
        configureWorkersWithoutContractGrid();
    }

    @Override
    public void configureFront() {
        setSizeFull();
        setClassName("grid-layout");
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("background-color", "#0D1219");
        add(workersWithoutContractGrid);
    }
    private void configureWorkersWithoutContractGrid(){
        workersWithoutContractGrid = new Grid<>(Worker.class);
        workersWithoutContractGrid.addClassName("grid");
        workersWithoutContractGrid.setColumns("firstName", "lastName", "pesel");
        workersWithoutContractGrid.getColumnByKey("firstName").setHeader("Imie").setTextAlign(ColumnTextAlign.CENTER);
        workersWithoutContractGrid.getColumnByKey("lastName").setHeader("Nazwisko").setTextAlign(ColumnTextAlign.CENTER);
        workersWithoutContractGrid.getColumnByKey("pesel").setHeader("PESEL").setTextAlign(ColumnTextAlign.CENTER);
        workersWithoutContractGrid.setItems(workerService.getWorkersWithoutContract());
        workersWithoutContractGrid.setSizeFull();
        workersWithoutContractGrid.getStyle().set("vaadin-grid-cell-background", "#0D1219");

    }
}
