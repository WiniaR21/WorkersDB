package com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.components.fields.worker.*;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerInfoDialogCompanyCostsLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WorkerInfoDialog workerInfoDialog;
    private final Worker workerSelectedFromGrid;

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
        setEmerytalna();
        setRentowa();
        setChorobowe();
        setZdrowotne();
        setKosztyUzyskaniaPrzychodu();
        setZaliczkaNaPodatekDochodowy();
        setKwotaDoWyplaty();
    }

    @Override
    public void configureFront() {
        add(
                emerytalna,
                rentowa,
                chorobowe,
                zdrowotne,
                kosztyUzyskaniaPrzychodu,
                zaliczkaNaPodatekDochodowy,
                kwotaDoWyplaty
        );
    }

    private void setEmerytalna( ) {
        emerytalna = new WorkerSkladkaEmerytalna(workerSelectedFromGrid);
        emerytalna.configure();
    }

    private void setRentowa( ) {
        rentowa = new WorkerSkladkaRentowa(workerSelectedFromGrid);
        rentowa.configure();
    }

    private void setChorobowe( ) {
        chorobowe = new WorkerSkladkaNaUbezpieczenieChorobowe(workerSelectedFromGrid);
        chorobowe.configure();
    }

    private void setZdrowotne( ) {
        zdrowotne = new WorkerSkladkaNaUbezpieczenieZdrowotne(workerSelectedFromGrid);
        zdrowotne.configure();
    }

    private void setKosztyUzyskaniaPrzychodu( ) {
        kosztyUzyskaniaPrzychodu = new WorkerKosztyUzyskaniaPrzychodu(workerSelectedFromGrid);
        kosztyUzyskaniaPrzychodu.configure();
    }

    private void setZaliczkaNaPodatekDochodowy( ) {
        zaliczkaNaPodatekDochodowy = new WorkerZaliczkaNaPodatekDochodowy(workerSelectedFromGrid);
        zaliczkaNaPodatekDochodowy.configure();
    }

    private void setKwotaDoWyplaty( ) {
        kwotaDoWyplaty = new WorkerKwotaDoWyplaty(workerSelectedFromGrid);
        kwotaDoWyplaty.configure();
    }
}
