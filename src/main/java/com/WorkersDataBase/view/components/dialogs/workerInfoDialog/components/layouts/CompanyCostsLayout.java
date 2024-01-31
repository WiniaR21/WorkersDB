package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.buttons.CloseWorkerInfoDialogButton;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.fields.company.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyCostsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;
    private final Worker workerSelectedFromGrid;

    //  To configure
    CompanySkladkaEmerytalna emerytalna;
    CompanySkladkaRentowa rentowa;
    CompanySkladkaNaUbezpieczenieWypadkowe ubezpieczenieWypadkowe;
    CompanySkladkaNaFunduszPracy funduszPracy;
    CompanySkladkaNaFGSP fGSP;
    CompanyLacznyKoszt lacznyKoszt;

    CloseWorkerInfoDialogButton closeWorkerInfoDialogButton;

    @Override
    public void configureComponents() {
        setEmerytalna();
        setRentowa();
        setUbezpieczenieWypadkowe();
        setFunduszPracy();
        setfGSP();
        setLacznyKoszt();
        setCloseWorkerInfoDialogButton();
    }

    @Override
    public void configureFront() {
        add(
                emerytalna,
                rentowa,
                ubezpieczenieWypadkowe,
                funduszPracy,
                fGSP,
                lacznyKoszt,
                closeWorkerInfoDialogButton
        );
    }

    private void setEmerytalna() {
        emerytalna = new CompanySkladkaEmerytalna(workerSelectedFromGrid);
        emerytalna.configure();
    }

    private void setRentowa() {
        rentowa = new CompanySkladkaRentowa(workerSelectedFromGrid);
        rentowa.configure();
    }

    private void setUbezpieczenieWypadkowe() {
        ubezpieczenieWypadkowe = new CompanySkladkaNaUbezpieczenieWypadkowe(workerSelectedFromGrid);
        ubezpieczenieWypadkowe.configure();
    }

    private void setFunduszPracy() {
        funduszPracy = new CompanySkladkaNaFunduszPracy(workerSelectedFromGrid);
        funduszPracy.configure();
    }

    private void setfGSP() {
        fGSP = new CompanySkladkaNaFGSP(workerSelectedFromGrid);
        fGSP.configure();
    }

    private void setLacznyKoszt() {
        lacznyKoszt = new CompanyLacznyKoszt(workerSelectedFromGrid);
        lacznyKoszt.configure();
    }

    private void setCloseWorkerInfoDialogButton() {
        closeWorkerInfoDialogButton = new CloseWorkerInfoDialogButton(workerInfoDialog);
        closeWorkerInfoDialogButton.configure();
    }
}
