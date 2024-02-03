package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.contact.ContactRepository;
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

class EmailIsUniqueTest {
    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private WorkerValidTool workerValidTool;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void emailIsUnique_should_return_false() {
        // Arrange
        Worker worker = getValidWorker();
        when(contactRepository.existsByEmail(worker.getContact().getEmail())).thenReturn(true);
        // Assert
        assertFalse(workerValidTool.emailIsUnique(worker));
    }
    @Test
    void emailIsUnique_should_return_true() {
        // Arrange
        Worker worker = getValidWorker();
        when(contactRepository.existsByEmail(worker.getContact().getEmail())).thenReturn(false);
        // Assert
        assertTrue(workerValidTool.emailIsUnique(worker));
    }

    private Worker getValidWorker(){
        Worker worker = new Worker();
        worker.setFirstName("Daniel");
        worker.setLastName("Winiarczyk");
        worker.setPersonalNumber("77082383532");

        Contact contact = new Contact("dw@gmail.com");
        contact.setWorker(worker);
        worker.setContact(contact);

        return worker;
    }
}