package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.fields;

import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralFGSP extends NumberField implements ComponentCreator {
    private final ContractService contractService;
    Div plnSuffix;
    @Override
    public void configureComponents() {
        plnSuffix = new Div();
        plnSuffix.setText("PLN");
    }

    @Override
    public void configureFront() {
        setLabel("Składki na FGSP");
        setReadOnly(true);
        setValue(contractService.getSumFGSP());
        setSuffixComponent(plnSuffix);

    }
}
