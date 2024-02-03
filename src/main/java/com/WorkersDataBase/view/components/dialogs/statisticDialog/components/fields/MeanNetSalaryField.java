package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields;

import com.WorkersDataBase.service.workersFee.WorkersFeeGetService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeanNetSalaryField
        extends NumberField
        implements ComponentCreator
{
    //  To inject by constructor
    private final WorkersFeeGetService workersFeeGetService;

    //  To configure
    Div plnSuffix;

    @Override
    public void configureComponents() {
        plnSuffix = new Div();
        plnSuffix.setText("PLN");
    }
    @Override
    public void configureFront() {
        setLabel("Śr. wynagrodzenie netto");
        setReadOnly(true);
        setValue(workersFeeGetService.getAvgNetSalary());
        setSuffixComponent(plnSuffix);
    }
}
