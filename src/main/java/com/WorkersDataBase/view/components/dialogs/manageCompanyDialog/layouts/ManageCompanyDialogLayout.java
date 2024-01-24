package com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.layouts;

import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.AddNewPositionButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.CancelButton;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ManageCompanyDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final ManageCompanyDialog manageCompanyDialog;
    private final PositionService positionService;

    // To configure
    AddNewPositionButton addNewPositionButton;
    RemovePositionButton removePositionButton;
    CancelButton cancelButton;
    H3 header;

    @Override
    public void configureComponents() {
        configureHeader();
        configureAddNewPositionButton();
        configureRemovePositionButton();
        configureCancelButton();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.STRETCH);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                addNewPositionButton,
                removePositionButton,
                cancelButton
        );
    }

    private void configureHeader(){
        header = new H3("Zarządzanie");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }

    private void configureAddNewPositionButton(){
        addNewPositionButton =
                new AddNewPositionButton(manageCompanyDialog, positionService);
        addNewPositionButton.configure();
    }

    private void configureRemovePositionButton(){
        removePositionButton =
                new RemovePositionButton(positionService, manageCompanyDialog);
        removePositionButton.configure();
    }

    private void configureCancelButton(){
        cancelButton = new CancelButton(manageCompanyDialog);
        cancelButton.configure();
    }
}
