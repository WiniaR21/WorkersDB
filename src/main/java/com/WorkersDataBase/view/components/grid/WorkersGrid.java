package com.WorkersDataBase.view.components.grid;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.worker.WorkerDeleteService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.worker.WorkerPostService;
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
    //  Components
    private final ServicePushNotification notification;
    private final WorkersGridSettings workersGridSettings;
    //  Services
    private final WorkerPostService workerPostService;
    private final ContractPostService contractPostService;
    private final PositionGetService positionGetService;
    private final WorkerDeleteService workerDeleteService;
    private final WorkerGetService workerGetService;

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
        grid.setItems(workerGetService.getWorkers());
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
                notification,
        this,
                event.getItem(),
                workerPostService,
                positionGetService,
                contractPostService,
                workerDeleteService,
                workerGetService
        );
        editWorkerDialog.configure();
    }
    public void refresh(){
        grid.setItems(workerGetService.getWorkers());
    }

}
