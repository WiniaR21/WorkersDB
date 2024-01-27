package com.WorkersDataBase.view.components.grid;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@RequiredArgsConstructor
public class WorkersGrid extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final PositionService positionService;
    private final ContractService contractService;
    private final WorkersGridSettings workersGridSettings;
    private final ServicePushNotification notification;

    //  To configure
    Grid<Worker> grid;

    @Override
    public void configureComponents() {
        configureGrid();
    }
    @Override
    public void configureFront() {
        setSizeFull();
        setClassName("grid-layout");
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("background-color", "#0D1219");
        add(grid);
    }
    private void configureGrid(){
        grid = new Grid<>(Worker.class);
        grid.addClassName("grid");
        grid.setColumns("firstName", "lastName", "pesel");
        grid.getColumnByKey("firstName").setHeader("Imie").setTextAlign(ColumnTextAlign.CENTER);
        grid.getColumnByKey("lastName").setHeader("Nazwisko").setTextAlign(ColumnTextAlign.CENTER);
        grid.getColumnByKey("pesel").setHeader("PESEL").setTextAlign(ColumnTextAlign.CENTER);
        grid.setItems(workerService.getWorkers());
        grid.setSizeFull();
        grid.getStyle().set("vaadin-grid-cell-background", "#0D1219");
        grid.addItemClickListener(this::openEditWorkerDialog);
    }
    public void setBySetting(Set<String> checkBoxValue){
        grid.removeAllColumns();
        workersGridSettings.setBySetting(checkBoxValue, grid);
    }
    private void openEditWorkerDialog(ItemClickEvent<Worker> event){

        EditWorkerDialog editWorkerDialog = new EditWorkerDialog(
                workerService,
                this,
                event.getItem(),
                positionService,
                contractService,
                notification
        );
        editWorkerDialog.configure();
    }
    public void refresh(){
        grid.setItems(workerService.getWorkers());
    }

}
