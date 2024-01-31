package com.WorkersDataBase.view.components.dialogs.statisticDialog.components.layouts;

import com.WorkersDataBase.view.components.dialogs.dashboardDialog.DashboardDialog;
import com.WorkersDataBase.view.components.dialogs.statisticDialog.StatisticDialog;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatisticsDialogLayout extends VerticalLayout implements ComponentCreator {
    //  To inject by constructor
    private final StatisticDialog statisticDialog;
    private final DashboardDialog dashboardDialog;

    //  To configure
    H3 header;
    MeanFieldsLayout meanFieldsLayout;
    StatisticDialogButtonsLayout statisticDialogButtonsLayout;
    @Override
    public void configureComponents() {
        setHeader();
        setMeanFieldsLayout();
        setStatisticDialogButtonsLayout();
    }

    @Override
    public void configureFront() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(
                header,
                meanFieldsLayout,
                statisticDialogButtonsLayout
        );
    }

    private void setHeader(){
        header = new H3("Średnie w firmie");
        header.getStyle()
                .set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");
    }
    private void setMeanFieldsLayout() {
        meanFieldsLayout = new MeanFieldsLayout();
        meanFieldsLayout.configure();
    }
    private void setStatisticDialogButtonsLayout(){
        statisticDialogButtonsLayout = new StatisticDialogButtonsLayout(
                statisticDialog,
                dashboardDialog
        );
        statisticDialogButtonsLayout.configure();
    }
}
