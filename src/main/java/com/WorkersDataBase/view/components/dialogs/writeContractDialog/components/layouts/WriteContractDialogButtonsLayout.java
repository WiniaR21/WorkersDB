package com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.WriteContractDialog;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.buttons.CloseWriteContractDialogButton;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.buttons.WriteContractButton;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.EndContractDateField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.SalaryField;
import com.WorkersDataBase.view.components.dialogs.writeContractDialog.components.fields.StartContractDateField;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteContractDialogButtonsLayout extends HorizontalLayout implements ComponentCreator {
    //  To inject by constructor
    private final WriteContractDialog writeContractDialog;
    private final ContractService contractService;
    private final EditWorkerDialog editWorkerDialog;
    private final WorkersGrid workersGrid;
    private final ServicePushNotification notification;
    private final Worker worker;
    private final SalaryField salaryField;
    private final ComboBox<Position> position;
    private final StartContractDateField startContractDateField;
    private final EndContractDateField endContractDateField;

    //  To configure
    WriteContractButton writeContractButton;
    CloseWriteContractDialogButton closeDialogButton;
    @Override
    public void configureComponents() {
        setWriteContractButton();
        setCloseDialogButton();
    }

    @Override
    public void configureFront() {
        add(
                writeContractButton,
                closeDialogButton
        );
    }
    private void setWriteContractButton() {
        writeContractButton = new WriteContractButton(
              writeContractDialog,
                contractService,
                editWorkerDialog,
                workersGrid,
                notification,
                worker,
                salaryField,
                position,
                startContractDateField,
                endContractDateField
        );
        writeContractButton.configure();
    }
    private void setCloseDialogButton() {
        closeDialogButton = new CloseWriteContractDialogButton(
                writeContractDialog,
                editWorkerDialog
        );
        closeDialogButton.configure();
    }
}
