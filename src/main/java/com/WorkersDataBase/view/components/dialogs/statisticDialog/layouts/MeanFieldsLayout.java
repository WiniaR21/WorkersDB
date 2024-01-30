package com.WorkersDataBase.view.components.dialogs.statisticDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields.MeanAgeField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields.MeanCostForWorker;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields.MeanGrossSalaryField;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.dataFields.MeanNetSalaryField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MeanFieldsLayout extends VerticalLayout implements ComponentCreator {

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
        meanAgeField = new MeanAgeField();
        meanAgeField.configure();
    }

    private void setMeanGrossSalaryField() {
        meanGrossSalaryField = new MeanGrossSalaryField();
        meanGrossSalaryField.configure();
    }

    private void setMeanNetSalaryField() {
        meanNetSalaryField = new MeanNetSalaryField();
        meanNetSalaryField.configure();
    }

    private void setMeanCostForWorker() {
        meanCostForWorker = new MeanCostForWorker();
        meanCostForWorker.configure();
    }
}
