package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class NewPositionDialogTypeLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;

    //  To configure
    H3 header;
    NewPositionTypeDialogFieldsLayout fieldsLayout;
    NewPositionTypeDialogButtonsLayout buttonsLayout;


    @Override
    public void configureComponents() {
        configureHeader();
        configureFieldsLayout();
        configureButtonsLayout();
    }
    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                fieldsLayout,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader() {
        header = new H3("Nowe stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        fieldsLayout = new NewPositionTypeDialogFieldsLayout();
        fieldsLayout.configure();
    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new NewPositionTypeDialogButtonsLayout(
                newPositionTypeDialog,
                positionService,
                manageCompanyDialog,
                notification,
                fieldsLayout.positionNameField
        );
        buttonsLayout.configure();
    }
}
