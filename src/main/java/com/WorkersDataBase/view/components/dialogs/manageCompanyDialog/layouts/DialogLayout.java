package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.layouts;

import com.WorkersDataBase.service.contract.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.AddNewPositionButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.CancelButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.DismissWorkerButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
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
    DismissWorkerButton dismissWorkerButton;
    CancelButton cancelButton;

    @Override
    public void configureComponents() {
        addNewPositionButton = new AddNewPositionButton(manageCompanyDialog, positionService);
        dismissWorkerButton = new DismissWorkerButton();
        cancelButton = new CancelButton(manageCompanyDialog);
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);

        add(
                addNewPositionButton,
                dismissWorkerButton,
                cancelButton
        );
    }
}
