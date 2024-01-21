package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.layouts;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.AddNewPositionButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.CancelButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.RemovePosition;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;

    public DialogLayout(
            ManageCompanyDialog manageCompanyDialog,
            PositionService positionService
    ) {
        this.manageCompanyDialog = manageCompanyDialog;
        this.positionService = positionService;

        configureComponents();
        configureFront();
    }

    // To configure
    AddNewPositionButton addNewPositionButton;
    RemovePosition dismissWorkerButton;
    CancelButton cancelButton;
    H3 header;

    @Override
    public void configureComponents() {
        header = new H3("Zarządzanie");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        addNewPositionButton = new AddNewPositionButton(manageCompanyDialog, positionService);
        dismissWorkerButton = new RemovePosition(positionService, manageCompanyDialog);
        cancelButton = new CancelButton(manageCompanyDialog);
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                addNewPositionButton,
                dismissWorkerButton,
                cancelButton
        );
    }
}
