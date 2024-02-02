package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanAgeField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanCostForWorker;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanGrossSalaryField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanNetSalaryField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialogFieldsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService workerService;
    private final ContractService contractService;

    //  To configure
    MeanAgeField meanAgeField;
    MeanGrossSalaryField meanGrossSalaryField;
    MeanNetSalaryField meanNetSalaryField;
    MeanCostForWorker meanCostForWorker;

    @Override
    public void configureComponents() {
        setMeanAgeField();
        setMeanGrossSalaryField();
        setMeanNetSalaryField();
        setMeanCostForWorker();
    }

    @Override
    public void configureFront() {
        add(
                meanAgeField,
                meanGrossSalaryField,
                meanNetSalaryField,
                meanCostForWorker
        );
    }

    private void setMeanAgeField() {
        meanAgeField = new MeanAgeField(workerService);
        meanAgeField.configure();
    }

    private void setMeanGrossSalaryField() {
        meanGrossSalaryField = new MeanGrossSalaryField(contractService);
        meanGrossSalaryField.configure();
    }

    private void setMeanNetSalaryField() {
        meanNetSalaryField = new MeanNetSalaryField(contractService);
        meanNetSalaryField.configure();
    }

    private void setMeanCostForWorker() {
        meanCostForWorker = new MeanCostForWorker(contractService);
        meanCostForWorker.configure();
    }
}
