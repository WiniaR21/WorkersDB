package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.contract.contact.Contact;
import com.WorkersDataBase.data.contract.contact.ContactRepository;
import com.WorkersDataBase.data.contract.worker.Worker;
import com.WorkersDataBase.data.contract.worker.WorkerRepository;
import com.WorkersDataBase.service.validTools.StringValidTool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WorkerValidToolTest {

    @Autowired
    private  WorkerRepository workerRepository;
    @Autowired
    private  ContactRepository contactRepository;
    Worker worker;
    WorkerValidTool underTest;
    @BeforeEach
    void setUp() {

        worker = new Worker();
        underTest = new WorkerValidTool(
                new StringValidTool(),
                workerRepository,
                contactRepository
        );
    }

    @AfterEach
    void tearDown() {
        worker = null;
        workerRepository.deleteAll();
    }

    @Test
    void workerNoSpecialSymbols_should_return_true(){
        //  Given
        worker.setFirstName("Daniel");
        worker.setLastName("Kowalski");
        worker.setPesel("12312312312");
        //  Test
        assertTrue(underTest.noSpecialSymbols(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_a() {
        //  Given
        worker.setFirstName("Jan");
        //  Test
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_b() {
        //  Given
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        //  Test
        assertTrue(underTest.workerHasEmptyFields(worker));
    }
    @Test
    void workerHasEmptyFields_should_return_true_case_c() {
        //  Given
        Contact contact = new Contact("email@gmail.com");
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        worker.setContact(contact);
        //  Test
        assertTrue(underTest.workerHasEmptyFields(worker));
    }

    @Test
    void workerHasEmptyFields_should_return_false() {
        //  Given
        Contact contact = new Contact("email@gmail.com");
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        worker.setContact(contact);
        worker.setPesel("12312312312");
        //  Test
        assertFalse(underTest.workerHasEmptyFields(worker));

    }
    @Test
    void workerNoSpecialSymbols_should_return_false_case_a(){
        //  Given
        worker.setFirstName("Dan1el");
        worker.setLastName("K0walsk1");
        worker.setPesel("12312312312");
        //  Test
        assertFalse(underTest.noSpecialSymbols(worker));
    }
    @Test
    void workerNoSpecialSymbols_should_return_false_case_b(){
        //  Given
        worker.setFirstName("Daniel");
        worker.setLastName("Kowalski");
        worker.setPesel("123123123s2");
        //  Test
        assertFalse(underTest.noSpecialSymbols(worker));
    }

    @Test
    void peselIsUnique_should_return_true(){
        //  Given
        worker.setPesel("12312312312");
        workerRepository.save(worker);

        Worker newWorker = new Worker();
        newWorker.setPesel("32132132132");
        //  Test
        assertTrue(underTest.peselIsUnique(newWorker));
    }
    @Test
    void peselIsUnique_should_return_false(){
        //  Given
        worker.setPesel("12312312312");
        workerRepository.save(worker);
        //  Test
        assertFalse(underTest.peselIsUnique(worker));
    }

    @Test
    void emailIsUnique_should_return_true(){
        //  Given
        Contact contact = new Contact("email@gmail.com");
        contact.setWorker(worker);

        worker.setContact(contact);
        workerRepository.save(worker);

        Worker newWorker = new Worker();
        Contact newContact = new Contact("liame@gmail.com");
        newWorker.setContact(newContact);
        newContact.setWorker(newWorker);
        //  Test
        assertTrue(underTest.emailIsUnique(newWorker));
    }
    @Test
    void emailIsUnique_should_return_false(){
        //  Given
        Contact contact = new Contact("email@gmail.com");
        contact.setWorker(worker);

        worker.setContact(contact);
        workerRepository.save(worker);
        //  Test
        assertFalse(underTest.emailIsUnique(worker));
    }

    @Test
    void peselLengthIsFine_should_return_true(){
        //  Given
        worker.setPesel("12312312312");
        //  Test
        assertTrue(underTest.peselLengthIsFine(worker));
    }
    @Test
    void peselLengthIsFine_should_return_false(){
        //  Given
        worker.setPesel("123112");
        //  Test
        assertFalse(underTest.peselLengthIsFine(worker));
    }

    @Test
    void firstNameLengthIsFine_should_return_true(){
        //  Given
        worker.setFirstName("Jan");
        //  Test
        assertTrue(underTest.firstNameLengthIsFine(worker));
    }
    @Test
    void firstNameLengthIsFine_should_return_false(){
        //  Given
        worker.setFirstName("Ja");
        //  Test
        assertFalse(underTest.firstNameLengthIsFine(worker));
    }

    @Test
    void lastNameLengthIsFine_should_return_true(){
        //  Given
        worker.setLastName("Bąk");
        //  Test
        assertTrue(underTest.lastNameLengthIsFine(worker));
    }
    @Test
    void lastNameLengthIsFine_should_return_false(){
        worker.setLastName("Bą");
        assertFalse(underTest.lastNameLengthIsFine(worker));
    }
}