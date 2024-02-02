package com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.components.layouts;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.confirmFireWorkerDialog.FireWorkerConfirmDialog;
import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.EditWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireWorkerConfirmDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final Worker workerSelectedFromGrid;
    private final FireWorkerConfirmDialog fireWorkerConfirmDialog;
    private final EditWorkerDialog editWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    H3 header;
    FireWorkerConfirmDialogButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        add(
                header,
                new HorizontalLayout(buttonsLayout)
        );
    }
    @Override
    public void configureHeader(){
        String headerText =
                String.format(
                       "Zwolnić %s %s?",
                        workerSelectedFromGrid.getFirstName(),
                        workerSelectedFromGrid.getLastName());

        header = new H3(headerText);
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {}
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new FireWorkerConfirmDialogButtonsLayout(
                workerService,
                workersGrid,
                workerSelectedFromGrid,
                fireWorkerConfirmDialog,
                editWorkerDialog,
                notification
        );
        buttonsLayout.configure();
    }
}
