package com.WorkersDataBase.view.components.dialogs.confirmEditDialog.textfields;

import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.vaadin.flow.component.textfield.TextField;

public class WorkerDataField extends TextField implements ComponentCreator {
    //  To inject by constructor
    private final String data;
    private final boolean dataCollectedFromRepo;
    //  To configure
    String message;

    public WorkerDataField(String data, boolean dataCollectedFromRepo) {
        this.data = data;
        this.dataCollectedFromRepo = dataCollectedFromRepo;


        configureComponents();
        configureFront();
    }

    private String createTextMessage() {
        return dataCollectedFromRepo ? data + " ->" : data;
    }
    @Override
    public void configureComponents() {
        message = createTextMessage();
    }

    @Override
    public void configureFront() {
        setLabel("PESEL");
        setReadOnly(true);
        setValue(message);
    }
}
