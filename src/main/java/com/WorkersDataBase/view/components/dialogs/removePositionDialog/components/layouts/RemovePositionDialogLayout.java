package com.WorkersDataBase.view.components.dialogs.removePositionDialog.components.layouts;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.notification.ServicePushNotification;
import com.WorkersDataBase.service.position.PositionGetService;
import com.WorkersDataBase.service.position.PositionDeleteService;
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
    //  Components
    private final ManageCompanyDialog       manageCompanyDialog;
    private final ServicePushNotification   notification;
    private final RemovePositionDialog      removePositionDialog;
    //  Services
    private final PositionDeleteService     positionDeleteService;
    private final PositionGetService        positionGetService;

                    //  To configure
                    H3                      header;
                    ComboBox<Position>      positions;
        RemovePositionDialogButtonsLayout   buttonsLayout;

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
        positions.setItems(positionGetService.getPositions());
        positions.setItemLabelGenerator(Position::getPositionName);
    }
    @Override
    public void configureButtonsLayout() {
        buttonsLayout = new RemovePositionDialogButtonsLayout(
                removePositionDialog,
                manageCompanyDialog,
                positions,
                notification,
                positionDeleteService
        );
        buttonsLayout.configure();
    }
}
