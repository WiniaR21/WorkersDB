package com.WorkersDataBase.view.components.dialogs.removePositionDialog.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.buttons.CloseRemovePositionDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.buttons.RemovePositionButton;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final PositionService positionService;
    private final RemovePositionDialog removePositionDialog;
    private final ManageCompanyDialog manageCompanyDialog;

    //  To configure
    ComboBox<Position> positions;
    RemovePositionButton removePositionButton;
    CloseRemovePositionDialog closeRemovePositionDialog;
    H3 header;

    @Override
    public void configureComponents() {
        configureHeader();
        configurePositions();
        configureButtons();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                positions,
                new HorizontalLayout(removePositionButton, closeRemovePositionDialog)
        );
    }

    private void configureHeader(){
        header = new H3("Usuń stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void configurePositions(){
        positions = new ComboBox<>("Stanowiska");
        positions.setItems(positionService.getPositions());
        positions.setItemLabelGenerator(Position::getPositionName);
    }

    private void configureButtons(){
        removePositionButton = new RemovePositionButton(
                positions, positionService, removePositionDialog);
        removePositionButton.configure();

        closeRemovePositionDialog = new CloseRemovePositionDialog(
                removePositionDialog, manageCompanyDialog);
        closeRemovePositionDialog.configure();
    }
}
