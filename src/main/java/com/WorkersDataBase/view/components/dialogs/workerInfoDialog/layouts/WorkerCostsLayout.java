package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.layouts;

import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.dataFields.worker.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerCostsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;

    //  To configure
    WorkerSkladkaEmerytalna emerytalna;
    WorkerSkladkaRentowa rentowa;
    WorkerSkladkaNaUbezpieczenieChorobowe chorobowe;
    WorkerSkladkaNaUbezpieczenieZdrowotne zdrowotne;
    WorkerKosztyUzyskaniaPrzychodu kosztyUzyskaniaPrzychodu;
    WorkerZaliczkaNaPodatekDochodowy zaliczkaNaPodatekDochodowy;
    WorkerKwotaDoWyplaty kwotaDoWyplaty;


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

    private void setChorobowe( ) {
        this.chorobowe = chorobowe;
    }

    private void setZdrowotne( ) {
        this.zdrowotne = zdrowotne;
    }

    private void setKosztyUzyskaniaPrzychodu( ) {
        this.kosztyUzyskaniaPrzychodu = kosztyUzyskaniaPrzychodu;
    }

    private void setZaliczkaNaPodatekDochodowy( ) {
        this.zaliczkaNaPodatekDochodowy = zaliczkaNaPodatekDochodowy;
    }

    private void setKwotaDoWyplaty( ) {
        this.kwotaDoWyplaty = kwotaDoWyplaty;
    }
}
