package com.WorkersDataBase.view.components.dialogs.addWorkerDialog;

import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.HeadlineAddWorker;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts.ButtonsLayoutWorkerDialog;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts.AddWorkerLayout;
import com.WorkersDataBase.view.components.dialogs.addWorkerDialog.component.layouts.FieldsLayout;
import com.WorkersDataBase.service.WorkerService;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddWorkerDialog extends Dialog implements ComponentCreator {
    //  To inject by constructor
    private final WorkerService service;
    private final WorkersGrid workersGrid;

    public AddWorkerDialog(WorkerService service, WorkersGrid workersGrid) {
        this.service = service;
        this.workersGrid = workersGrid;

        configureComponents();
        configureFront();
    }

    // To configure
    FieldsLayout fieldsLayout;
    ButtonsLayoutWorkerDialog buttonsLayout;
    HeadlineAddWorker headlineAddWorker;
    AddWorkerLayout addWorkerLayout;

    @Override
    public void configureComponents(){
        fieldsLayout = new FieldsLayout();

        buttonsLayout = new ButtonsLayoutWorkerDialog(service,this, workersGrid, fieldsLayout);

        headlineAddWorker = new HeadlineAddWorker();

        addWorkerLayout = new AddWorkerLayout(headlineAddWorker, fieldsLayout,buttonsLayout);
    }
    @Override
    public void configureFront(){
        setModal(true);
        setCloseOnOutsideClick(false);
        add(addWorkerLayout);
    }
}
