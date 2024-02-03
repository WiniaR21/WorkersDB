package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields;

import com.WorkersDataBase.service.worker.WorkerGetService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeanAgeField
        extends NumberField
        implements ComponentCreator
{
    //  To inject by constructor
    private final WorkerGetService workerGetService;

    //  To configure
    Div ageSuffix;

    @Override
    public void configureComponents() {
        ageSuffix = new Div();
        ageSuffix.setText("lat");
    }
    @Override
    public void configureFront() {
        setLabel("Śr. wiek pracownika");
        setReadOnly(true);
        setValue(workerGetService.getAverageAge());
        setSuffixComponent(ageSuffix);
    }
}
