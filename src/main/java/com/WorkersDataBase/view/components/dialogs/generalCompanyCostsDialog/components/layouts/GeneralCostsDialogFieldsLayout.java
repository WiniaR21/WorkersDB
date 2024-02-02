package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;


import com.WorkersDataBase.service.getService.CompanyFeeGetService;
import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.fields.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralCostsDialogFieldsLayout
        extends VerticalLayout
        implements ComponentCreator
{
    //  To inject by constructor
    private final CompanyFeeGetService companyFeeGetService;
    //  To configure
    GeneralEmerytalna emerytalna;
    GeneralRentowa rentowa;
    GeneralWypadkowe wypadkowe;
    GeneralFunduszPracy funduszPracy;
    GeneralFGSP fgsp;
    GeneralCost cost;

    @Override
    public void configureComponents() {
        setEmerytalna();
        setRentowa();
        setWypadkowe();
        setFunduszPracy();
        setFgsp();
        setCost();
    }

    @Override
    public void configureFront() {
        add(
                emerytalna,
                rentowa,
                wypadkowe,
                funduszPracy,
                fgsp,
                cost
        );
    }
    private void setEmerytalna() {
        emerytalna = new GeneralEmerytalna(companyFeeGetService);
        emerytalna.configure();
    }
    private void setRentowa() {
        rentowa = new GeneralRentowa(companyFeeGetService);
        rentowa.configure();
    }
    private void setWypadkowe() {
        wypadkowe = new GeneralWypadkowe(companyFeeGetService);
        wypadkowe.configure();
    }
    private void setFunduszPracy() {
        funduszPracy = new GeneralFunduszPracy(companyFeeGetService);
        funduszPracy.configure();
    }
    private void setFgsp() {
        fgsp = new GeneralFGSP(companyFeeGetService);
        fgsp.configure();
    }
    private void setCost() {
        cost = new GeneralCost(companyFeeGetService);
        cost.configure();
    }
}
