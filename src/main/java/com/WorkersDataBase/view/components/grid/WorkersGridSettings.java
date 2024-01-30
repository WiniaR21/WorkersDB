package com.WorkersDataBase.view.components.grid;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class WorkersGridSettings {

    public void setBySetting(Set<String> checkBoxValue, Grid<Worker> grid){
        if(checkBoxValue.contains("Imie"))
           addFirstNameColumn(grid);

        if (checkBoxValue.contains("Nazwisko"))
            addLastNameColumn(grid);

        if (checkBoxValue.contains("PESEL"))
           addPeselColumn(grid);

        if (checkBoxValue.contains("Email"))
           addEmailColumn(grid);

        if (checkBoxValue.contains("Stanowisko"))
            addPositionColumn(grid);

        if (checkBoxValue.contains("Wynagrodzenie"))
            addSalaryColumn(grid);

        if (checkBoxValue.contains("Płeć"))
            addGenderColumn(grid);

        if (checkBoxValue.contains("Data urodzenia"))
            addBirthColumn(grid);

        if (checkBoxValue.contains("Wiek"))
            addAgeColumn(grid);

    }

    private void addFirstNameColumn(Grid<Worker> grid){
        grid.addColumn("firstName")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("Imie");
    }
    private void addLastNameColumn(Grid<Worker> grid){
        grid.addColumn("lastName")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("Nazwisko");
    }
    private void addPeselColumn(Grid<Worker> grid){
        grid.addColumn("pesel")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("PESEL");
    }
    private void addEmailColumn(Grid<Worker> grid){
        grid.addColumn(worker -> worker.getContact().getEmail())
                .setHeader("Email")
                .setTextAlign(ColumnTextAlign.CENTER);
    }
    private void addPositionColumn(Grid<Worker> grid){
        grid.addColumn(worker -> worker.getContract() != null ?
                        worker.getContract().getPosition().getPositionName() : "Brak")
                .setHeader("Stanowisko")
                .setTextAlign(ColumnTextAlign.CENTER);
    }
    private void addSalaryColumn(Grid<Worker> grid){
        grid.addColumn(worker -> worker.getContract() != null?
                worker.getContract().getSalary() + " PLN" : "Brak")
                .setHeader("Wynagrodzenie")
                .setTextAlign(ColumnTextAlign.CENTER);
    }
    private void addBirthColumn(Grid<Worker> grid) {
        grid.addColumn("birthDate")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("Data urodzenia");
    }

    private void addGenderColumn(Grid<Worker> grid) {
        grid.addColumn("gender")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("Płeć");
    }

    private void addAgeColumn(Grid<Worker> grid) {
        grid.addColumn("age")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setHeader("Wiek");
    }
}
