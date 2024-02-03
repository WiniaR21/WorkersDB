package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalNumberIsPossibleTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void personalNumberIsPossible_should_return_true() {
        generatedPeselList.forEach(
                personalNumber -> {
                    Worker worker = GetWorkers.getValidWorker();
                    worker.setPersonalNumber(personalNumber);
                    assertTrue(underTest.personalNumberIsPossible(worker));
                }
        );
    }
    List<String> generatedPeselList = List.of(
            "78010398723",
            "72021662642",
            "96122833356",
            "67051397118",
            "65092314837"
    );
}