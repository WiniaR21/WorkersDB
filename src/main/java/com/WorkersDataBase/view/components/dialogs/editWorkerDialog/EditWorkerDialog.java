package com.WorkersDataBase.view.components.dialogs.editWorkerDialog;

import com.WorkersDataBase.view.components.dialogs.editWorkerDialog.components.layouts.DialogLayout;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Getter;

@Getter
public class EditWorkerDialog extends Dialog implements ComponentCreator {
    DialogLayout dialogLayout;
    public EditWorkerDialog() {
        configureComponents();
        configureFront();
    }

    @Override
    public void configureComponents() {
        dialogLayout = new DialogLayout();
    }

    @Override
    public void configureFront() {
        add(dialogLayout);
    }

}
