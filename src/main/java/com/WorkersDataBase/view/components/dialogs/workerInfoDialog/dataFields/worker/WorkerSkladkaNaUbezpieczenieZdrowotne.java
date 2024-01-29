package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.worker;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerSkladkaNaUbezpieczenieZdrowotne extends TextField implements ComponentCreator {
    private final Worker workerSelectedFromGrid;
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Ubezpieczenie zdrowotne");
        setReadOnly(true);
        setValue(String.valueOf(workerSelectedFromGrid.getContract().getWorkersFee().getSkladkaNaUbezpieczenieZdrowotne()));
    }
}
