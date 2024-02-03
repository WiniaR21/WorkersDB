package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts;

import com.WorkersDataBase.service.companyFee.CompanyFeeGetService;
import com.WorkersDataBase.service.contract.ContractGetService;
import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.service.workersFee.WorkersFeeGetService;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanAgeField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanCostForWorker;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanGrossSalaryField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields.MeanNetSalaryField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticDialogFieldsLayout
        extends VerticalLayout
        implements ComponentCreator
{
    //  To inject by constructor
    private final WorkerGetService workerGetService;
    private final ContractGetService contractGetService;
    private final CompanyFeeGetService companyFeeGetService;
    private final WorkersFeeGetService workersFeeGetService;

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
        meanAgeField = new MeanAgeField(workerGetService);
        meanAgeField.configure();
    }

    private void setMeanGrossSalaryField() {
        meanGrossSalaryField = new MeanGrossSalaryField(contractGetService);
        meanGrossSalaryField.configure();
    }

    private void setMeanNetSalaryField() {
        meanNetSalaryField = new MeanNetSalaryField(workersFeeGetService);
        meanNetSalaryField.configure();
    }

    private void setMeanCostForWorker() {
        meanCostForWorker = new MeanCostForWorker(companyFeeGetService);
        meanCostForWorker.configure();
    }
}
