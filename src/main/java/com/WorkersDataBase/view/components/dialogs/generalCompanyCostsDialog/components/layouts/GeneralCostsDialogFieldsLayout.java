package com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.generalCompanyCostsDialog.components.fields.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class GeneralCostsDialogFieldsLayout extends VerticalLayout implements ComponentCreator {
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
        emerytalna = new GeneralEmerytalna();
        emerytalna.configure();
    }
    private void setRentowa() {
        rentowa = new GeneralRentowa();
        rentowa.configure();
    }
    private void setWypadkowe() {
        wypadkowe = new GeneralWypadkowe();
        wypadkowe.configure();
    }
    private void setFunduszPracy() {
        funduszPracy = new GeneralFunduszPracy();
        funduszPracy.configure();
    }
    private void setFgsp() {
        fgsp = new GeneralFGSP();
        fgsp.configure();
    }
    private void setCost() {
        cost = new GeneralCost();
        cost.configure();
    }
}
