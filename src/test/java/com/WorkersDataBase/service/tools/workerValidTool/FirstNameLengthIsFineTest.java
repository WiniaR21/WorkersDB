package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstNameLengthIsFineTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void firstNameLengthIsFine_should_return_false_case_a() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName("12");
        //  Assert
        assertFalse(underTest.firstNameLengthIsFine(worker));
    }
    @Test
    void firstNameLengthIsFine_should_return_false_case_B() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName("123456789012345");
        //  Assert
        assertFalse(underTest.firstNameLengthIsFine(worker));
    }
    @Test
    void firstNameLengthIsFine_should_return_true() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName("1234567");
        //  Assert
        assertTrue(underTest.firstNameLengthIsFine(worker));
    }

}