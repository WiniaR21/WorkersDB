package com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.layouts;

import com.WorkersDataBase.service.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.NewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.CancelNewPositionTypeDialog;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.buttons.SaveNewPositionType;
import com.WorkersDataBase.view.components.dialogs.newPositionTypeDialog.components.dataFields.PositionNameField;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NewPositionDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final NewPositionTypeDialog newPositionTypeDialog;
    private final PositionService positionService;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;

    //  To configure
    H3 header;
    PositionNameField positionNameField;
    SaveNewPositionType saveNewPositionType;
    CancelNewPositionTypeDialog cancelNewPositionTypeDialog;


    @Override
    public void configureComponents() {
        configureHeader();
        configurePositionNameField();
        configureCancelNewPositionTypeDialog();
        configureSaveNewPositionType();
    }
    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                positionNameField,

                new HorizontalLayout(saveNewPositionType, cancelNewPositionTypeDialog));
    }
    private void configureHeader(){
        header = new H3("Nowe stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void configurePositionNameField(){
        positionNameField = new PositionNameField();
        positionNameField.configure();
    }
    private void configureCancelNewPositionTypeDialog(){
        cancelNewPositionTypeDialog = new CancelNewPositionTypeDialog(
                newPositionTypeDialog, manageCompanyDialog);

        cancelNewPositionTypeDialog.configure();
    }
    private void configureSaveNewPositionType(){
        saveNewPositionType = new SaveNewPositionType(
                positionNameField,
                positionService,
                newPositionTypeDialog,
                notification
        );

        saveNewPositionType.configure();
    }
}
