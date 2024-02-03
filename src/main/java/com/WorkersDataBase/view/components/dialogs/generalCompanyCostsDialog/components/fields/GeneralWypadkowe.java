package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.fields;

import com.WorkersDataBase.service.companyFee.CompanyFeeGetService;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralWypadkowe extends NumberField implements ComponentCreator {
    private final CompanyFeeGetService companyFeeGetService;
    Div plnSuffix;
    @Override
    public void configureComponents() {
        plnSuffix = new Div();
        plnSuffix.setText("PLN");
    }

    @Override
    public void configureFront() {
        setLabel("Składki wypadkowe");
        setReadOnly(true);
        setValue(companyFeeGetService.getSumUbezpieczenieWypadkowe());
        setSuffixComponent(plnSuffix);
    }
}
