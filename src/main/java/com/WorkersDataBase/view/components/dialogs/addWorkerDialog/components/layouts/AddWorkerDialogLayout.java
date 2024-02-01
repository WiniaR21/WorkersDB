package com.WorkersDataBase.view.components.dialogs.addWorkerDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.AddWorkerDialog;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddWorkerDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final AddWorkerDialog addWorkerDialog;
    private final ServicePushNotification notification;

    //  To configure
    H3 header;
    AddWorkerDialogFieldsLayout fieldsLayout;
    AddWorkerDialogButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront(){
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);
        getStyle().set("width", "300px").set("max-width", "100%");

        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader() {
        header = new H3("Dodaj pracownika");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new AddWorkerDialogFieldsLayout();
        fieldsLayout.configure();
    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new AddWorkerDialogButtonsLayout(
                workerService,
                workersGrid,
                addWorkerDialog,
                fieldsLayout.firstNameField,
                fieldsLayout.lastNameField,
                fieldsLayout.emailField,
                fieldsLayout.peselField,
                notification
        );
        buttonsLayout.configure();
    }
}
