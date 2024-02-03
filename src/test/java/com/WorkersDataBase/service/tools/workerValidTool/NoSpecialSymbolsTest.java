package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoSpecialSymbolsTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void noSpecialSymbols_should_return_false_case_firstName_typo(){
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setFirstName("Dan1el");
        //  Assert
        assertFalse(underTest.noSpecialSymbols(worker));
    }
    @Test
    void noSpecialSymbols_should_return_false_case_lastName_typo(){
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setLastName("K0walski");
        //  Assert
        assertFalse(underTest.noSpecialSymbols(worker));
    }
    @Test
    void noSpecialSymbols_should_return_false_case_personalNumber_typo(){
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        worker.setPersonalNumber("123123123q1");
        //  Assert
        assertFalse(underTest.noSpecialSymbols(worker));
    }
    @Test
    void noSpecialSymbols_should_return_true(){
        //  Arrange
        Worker worker = GetWorkers.getValidWorker();
        //  Assert
        assertTrue(underTest.noSpecialSymbols(worker));
    }
}