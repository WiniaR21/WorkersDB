package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonalNumberIsUniqueTest {
    @Mock
    private WorkerRepository workerRepository;

    @InjectMocks
    private WorkerValidTool underTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void personalNumberIsUnique_should_return_false() {
        // Arrange
        Worker worker = GetWorkers.getValidWorker();
        when(workerRepository.existsByPesel(worker.getPersonalNumber())).thenReturn(true);
        // Assert
        assertFalse(underTest.personalNumberIsUnique(worker));
    }
    @Test
    void personalNumberIsUnique_should_return_true() {
        // Arrange
        Worker worker = GetWorkers.getValidWorker();
        when(workerRepository.existsByPesel(worker.getPersonalNumber())).thenReturn(false);
        // Assert
        assertTrue(underTest.personalNumberIsUnique(worker));
    }
}