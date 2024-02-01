package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ManageCompanyDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;
    private final ServicePushNotification notification;

    // To configure
    H3 header;
    ManageCompanyDialogButtonsLayout buttonsLayout;

    @Override
    public void configureComponents() {
        configureHeader();
        configureButtonsLayout();

    }
    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader(){
        header = new H3("Zarządzanie");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {

    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new ManageCompanyDialogButtonsLayout(
                manageCompanyDialog,
                positionService,
                notification
        );
        buttonsLayout.configure();
    }
}
