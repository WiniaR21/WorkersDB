package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.company.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyCosts extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;

    //  To configure
    CompanySkladkaEmerytalna emerytalna;
    CompanySkladkaRentowa rentowa;
    CompanySkladkaNaUbezpieczenieWypadkowe ubezpieczenieWypadkowe;
    CompanySkladkaNaFunduszPracy funduszPracy;
    CompanySkladkaNaFGSP fGSP;

    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {

    }

    private void setEmerytalna( ) {
        this.emerytalna = emerytalna;
    }

    private void setRentowa( ) {
        this.rentowa = rentowa;
    }

    private void setUbezpieczenieWypadkowe( ) {
        this.ubezpieczenieWypadkowe = ubezpieczenieWypadkowe;
    }

    private void setFunduszPracy( ) {
        this.funduszPracy = funduszPracy;
    }

    private void setfGSP( ) {
        this.fGSP = fGSP;
    }
}
