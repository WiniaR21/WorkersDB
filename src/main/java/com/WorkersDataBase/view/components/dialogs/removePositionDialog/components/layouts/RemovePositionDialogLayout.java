package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.view.components.dialogs.manageCompanyDialog.ManageCompanyDialog;
import com.WorkersDataBase.view.components.dialogs.removePositionDialog.RemovePositionDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.interfaces.DialogLayoutCreator;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemovePositionDialogLayout
        extends VerticalLayout
        implements ComponentCreator, DialogLayoutCreator
{
    //  To inject by constructor
    private final PositionService positionService;
    private final RemovePositionDialog removePositionDialog;
    private final ManageCompanyDialog manageCompanyDialog;
    private final ServicePushNotification notification;


    //  To configure
    H3 header;
    ComboBox<Position> positions;
    RemovePositionDialogButtonsLayout buttonsLayout;

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
                positions,
                buttonsLayout
        );
    }
    @Override
    public void configureHeader(){
        header = new H3("Usuń stanowisko");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    @Override
    public void configureFieldsLayout() {
        positions = new ComboBox<>("Stanowiska");
        positions.setItems(positionService.getPositions());
        positions.setItemLabelGenerator(Position::getPositionName);
    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new RemovePositionDialogButtonsLayout(
                positionService,
                removePositionDialog,
                manageCompanyDialog,
                notification,
                positions
        );
        buttonsLayout.configure();
    }
}
