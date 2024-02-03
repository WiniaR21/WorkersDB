package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractPostService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  Components
    private final ServicePushNotification   notification;
    private final WorkersGrid               workersGrid;
    private final Worker                    worker;
    private final boolean                   workerHasContract;
    private final EditWorkerDialog          editWorkerDialog;
    private final WriteContractDialog       writeContractDialog;
    //  Services
    private final PositionGetService        positionGetService;
    private final ContractPostService contractPostService;

    //   To configure
    H3                                 header;
    WriteContractDialogFieldsLayout    fieldsLayout;
    WriteContractDialogButtonsLayout   buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
            add(
                    header,
                    fieldsLayout,
                    buttonsLayout
            );
    }
    @Override
    public void configureHeader(){
        if(workerHasContract) header = new H3("Zmień umowę");
        else header = new H3("Podpisz nową umowę");

        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new WriteContractDialogFieldsLayout(
                positionGetService
        );
        fieldsLayout.configure();
    }

    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new WriteContractDialogButtonsLayout(
                writeContractDialog,
                contractPostService,
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
