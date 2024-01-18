package com.WorkersDataBase.view.components.grid;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Setter;

import java.util.Set;

@Setter
public class WorkersGrid extends HorizontalLayout implements ComponentCreator {
    Grid<Worker> grid;
    WorkerService service;
    public WorkersGrid(WorkerService service) {
        this.service = service;
        configureComponents();
        configureFront();

    }
    @Override
    public void configureComponents() {
        grid = new Grid<>(Worker.class);
        grid.addClassName("grid");
        grid.setColumns("firstName", "lastName", "pesel");
        grid.getColumnByKey("firstName").setHeader("Imie").setTextAlign(ColumnTextAlign.CENTER);
        grid.getColumnByKey("lastName").setHeader("Nazwisko").setTextAlign(ColumnTextAlign.CENTER);
        grid.getColumnByKey("pesel").setHeader("PESEL").setTextAlign(ColumnTextAlign.CENTER);
        grid.setItems(service.getWorkers());
        grid.setSizeFull();
        grid.getStyle().set("vaadin-grid-cell-background", "#0D1219");
        grid.addItemClickListener(workerClicked -> System.out.println(workerClicked.getItem()));
    }

    @Override
    public void configureFront() {
        setSizeFull();
        setClassName("grid-layout");
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("background-color", "#0D1219");
        add(grid);
    }

    public void refresh(){
        grid.setItems(service.getWorkers());
    }
    public void setBySetting(Set<String> checkBoxValue){
        grid.removeAllColumns();
        if(checkBoxValue.contains("Imie")){
            grid.addColumn("firstName").setTextAlign(ColumnTextAlign.CENTER);
            grid.getColumnByKey("firstName").setHeader("Imie");
        }
        if (checkBoxValue.contains("Nazwisko")){
            grid.addColumn("lastName").setTextAlign(ColumnTextAlign.CENTER);
            grid.getColumnByKey("lastName").setHeader("Nazwisko");
        }
        if (checkBoxValue.contains("PESEL")){
            grid.addColumn("pesel").setTextAlign(ColumnTextAlign.CENTER);
            grid.getColumnByKey("pesel").setHeader("PESEL");
        }
        if (checkBoxValue.contains("Email")){
            grid.addColumn(worker -> worker.getContact().getEmail()).setHeader("Email").setTextAlign(ColumnTextAlign.CENTER);
        }

    }


}
