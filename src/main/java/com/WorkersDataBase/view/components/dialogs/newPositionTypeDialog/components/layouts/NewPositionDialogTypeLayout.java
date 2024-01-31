package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class NewPositionDialogTypeLayout extends VerticalLayout implements ComponentCreator {
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
        setHeader();
        setFieldsLayout();
        setButtonsLayout();
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
    private void setHeader(){
        header = new H3("Nowe stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void setFieldsLayout(){
        fieldsLayout = new NewPositionTypeDialogFieldsLayout();
        fieldsLayout.configure();
    }
    private void setButtonsLayout(){
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
