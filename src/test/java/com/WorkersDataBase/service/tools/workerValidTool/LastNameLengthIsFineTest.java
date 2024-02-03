package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import com.WorkersDataBase.service.tools.workerValidTool.GetWorkers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class LastNameLengthIsFineTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void lastNameLengthIsFine_should_return_false_case_a() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName("01");
        //  Assert
        assertFalse(underTest.lastNameLengthIsFine(worker));
    }
    @Test
    void lastNameLengthIsFine_should_return_false_case_b() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName("012345678901234567890");
        //  Assert
        assertFalse(underTest.lastNameLengthIsFine(worker));
    }
    @Test
    void lastNameLengthIsFine_should_return_true() {
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName("01234567890");
        //  Assert
        assertTrue(underTest.lastNameLengthIsFine(worker));
    }
}