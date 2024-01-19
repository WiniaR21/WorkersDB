package com.WorkersDataBase.service.dialogs.textfields;

import com.vaadin.flow.component.textfield.TextField;

public class PeselField extends TextField {
    String originalPesel;
    String newPesel;

    public PeselField(String originalPesel, String newPesel) {
        this.originalPesel = originalPesel;
        this.newPesel = newPesel;
    }
}
