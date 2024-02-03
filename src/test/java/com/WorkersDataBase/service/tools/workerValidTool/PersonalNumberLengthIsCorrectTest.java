package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PersonalNumberLengthIsCorrectTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void personalNumberLengthIsCorrect_should_return_false_case_a() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setPersonalNumber("1231231231");
        //  Assert
        assertFalse(underTest.personalNumberLengthIsCorrect(worker));
    }
    @Test
    void personalNumberLengthIsCorrect_should_return_false_case_b() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setPersonalNumber("123123123123");
        //  Assert
        assertFalse(underTest.personalNumberLengthIsCorrect(worker));
    }
    @Test
    void personalNumberLengthIsCorrect_should_return_true() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        //  Assert
        assertTrue(underTest.personalNumberLengthIsCorrect(worker));
    }

}