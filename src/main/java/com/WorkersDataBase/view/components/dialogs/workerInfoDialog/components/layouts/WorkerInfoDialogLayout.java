package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialogLayout
        extends HorizontalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    // To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;
    private final Worker workerSelectedFromGrid;

    //  To configure
    WorkerInfoDialogWorkerCostsLayout workerCostsLayout;
    WorkerInfoDialogCompanyCostsLayout companyCostsLayout;

    @Override
    public void configureComponents() {
        setWorkerCostsLayout();
        setCompanyCostsLayout();
    }

    @Override
    public void configureFront() {
        add(workerCostsLayout, companyCostsLayout);
    }
    private void setWorkerCostsLayout( ) {
        workerCostsLayout = new WorkerInfoDialogWorkerCostsLayout(
                workerInfoDialog,
                workerSelectedFromGrid
        );
        workerCostsLayout.configure();
    }
    private void setCompanyCostsLayout( ) {
        companyCostsLayout = new WorkerInfoDialogCompanyCostsLayout(
                workerInfoDialog,
                workerSelectedFromGrid
        );
        companyCostsLayout.configure();
    }

    @Override
    public void configureHeader() {

    }

    @Override
    public void configureFieldsLayout() {

    }

    @Override
    public void configureButtonsLayout() {

    }
}
