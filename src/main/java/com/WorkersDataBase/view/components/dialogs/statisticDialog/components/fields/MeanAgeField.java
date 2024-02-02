package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.fields;

import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeanAgeField extends NumberField implements ComponentCreator {
    private final WorkerService workerService;
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
        setValue(workerService.getAverageAge());
        setSuffixComponent(ageSuffix);
    }
}
