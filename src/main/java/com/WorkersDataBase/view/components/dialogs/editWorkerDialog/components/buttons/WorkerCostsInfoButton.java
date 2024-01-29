package com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.buttons;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.workerInfoDialog.WorkerInfoDialog;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.button.Button;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkerCostsInfoButton extends Button implements ComponentCreator, ButtonCreator {
    private final WorkerService workerService;
    private final Worker workerSelectedFromGrid;
    private final ServicePushNotification notification;
    @Override
    public void configureComponents() {

    }

    @Override
    public void configureFront() {
        setText("Informacje");
        addClickListener(e -> clickEvent());
    }

    @Override
    public void clickEvent() {
        if (workerSelectedFromGrid.getContract() == null){
            notification.pushCanNotShowInfoNoContract();
        }
        else {
            WorkerInfoDialog workerInfoDialogLayout
                    = new WorkerInfoDialog(
                            workerSelectedFromGrid
                    );
            workerInfoDialogLayout.configure();
        }






    }
}
