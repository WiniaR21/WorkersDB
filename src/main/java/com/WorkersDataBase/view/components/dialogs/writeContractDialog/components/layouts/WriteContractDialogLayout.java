package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final PositionService positionService;
    private final Worker worker;
    private final ContractService contractService;
    private final boolean workerHasContract;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;

    //   To configure
    H3 header;
    WriteContractDialogFieldsLayout fieldsLayout;
    WriteContractDialogButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        setFieldsLayout();
        setButtonsLayout();
    }
    @Override
    public void configureFront() {
            add(
                    header,
                    fieldsLayout,
                    buttonsLayout
            );
    }
    private void configureHeader(){
        if(workerHasContract) header = new H3("Zmień umowę");
        else header = new H3("Podpisz nową umowę");

        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
   private void setFieldsLayout(){
        fieldsLayout = new WriteContractDialogFieldsLayout(
                positionService
        );
        fieldsLayout.configure();
   }
   private void setButtonsLayout(){
        buttonsLayout = new WriteContractDialogButtonsLayout(
                writeContractDialog,
                contractService,
                editWorkerDialog,
                workersGrid,
                notification,
                worker,
                fieldsLayout.salaryField,
                fieldsLayout.position,
                fieldsLayout.startContractDateField,
                fieldsLayout.endContractDateField
        );
        buttonsLayout.configure();
   }
}
