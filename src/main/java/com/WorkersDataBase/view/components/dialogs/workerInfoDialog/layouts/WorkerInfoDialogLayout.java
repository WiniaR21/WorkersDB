package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialogLayout extends HorizontalLayout implements ComponentCreator {
    // To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;
    private final Worker workerSelectedFromGrid;

    //  To configure
    CompanyCostsLayout companyCostsLayout;
    WorkerCostsLayout workerCostsLayout;

    @Override
    public void configureComponents() {
        setCompanyCostsLayout();
        setWorkerCostsLayout();
    }

    @Override
    public void configureFront() {
        add(companyCostsLayout, workerCostsLayout);
    }

    private void setCompanyCostsLayout( ) {
        companyCostsLayout = new CompanyCostsLayout(workerInfoDialog, workerSelectedFromGrid);
        companyCostsLayout.configure();
    }

    private void setWorkerCostsLayout( ) {
        workerCostsLayout = new WorkerCostsLayout(workerInfoDialog, workerSelectedFromGrid);
        workerCostsLayout.configure();
    }
}
