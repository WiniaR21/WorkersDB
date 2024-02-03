package com.WorkersDataBase.service.tools;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WorkerValidToolTest {
    @Mock
    private WorkerRepository workerRepository;

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private WorkerValidTool workerValidTool;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void noSpecialSymbols() {
    }

    @Test
    void emailIsUnique_should_return_true() {
        // Arrange
        Worker worker = getValidWorker();
        when(workerRepository.existsByPesel(worker.getPersonalNumber())).thenReturn(true);

        // Assert
        assertTrue(workerValidTool.emailIsUnique(worker));
    }
    @Test
    void emailIsUnique_should_return_false() {
        // Arrange
        Worker worker = getValidWorker();
        when(workerRepository.existsByPesel(worker.getPersonalNumber())).thenReturn(false);

        // Assert
        assertTrue(workerValidTool.emailIsUnique(worker));
    }

    @Test
    void personalNumberIsUnique() {
    }

    @Test
    void personalNumberLengthIsFine() {
    }

    @Test
    void personalNumberIsPossible() {
    }

    @Test
    void firstNameLengthIsFine() {
    }

    @Test
    void lastNameLengthIsFine() {
    }

    @Test
    void isStringLetters() {
    }

    @Test
    void isStringDigits() {
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