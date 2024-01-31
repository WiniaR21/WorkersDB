package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.fields.company;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanySkladkaEmerytalna extends TextField implements ComponentCreator {
    private final Worker workerSelectedFromGrid;
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setLabel("Składka emerytalna");
        setReadOnly(true);
        setValue(String.valueOf(workerSelectedFromGrid.getContract().getCompanyFee().getSkladkaEmerytalna()));
    }
}
