package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.fields.worker;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerSkladkaNaUbezpieczenieChorobowe extends TextField implements ComponentCreator {
    private final Worker workerSelectedFromGrid;
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Ubezpieczenie chorobowe");
        setReadOnly(true);
        setValue(String.valueOf(workerSelectedFromGrid.getContract().getWorkersFee().getSkladkaNaUbezpieczenieChorobowe()));
    }
}
