package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class WorkerHasEmptyFieldsTest {

    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void workerHasEmptyFields_should_return_true_case_firstName_case_A() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName("");
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_firstName_case_B() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName(null);
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_lastName_case_A() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName("");
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_lastName_case_B() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName(null);
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_email_case_A() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.getContact().setEmail("");
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_email_case_B() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setContact(null);
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_personalNumber_case_A() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setPersonalNumber("");
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_personalNumber_case_B() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setPersonalNumber(null);
        //  Assert
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_false() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        //  Assert
        assertFalse(underTest.workerHasEmptyFields(worker));
    }
}