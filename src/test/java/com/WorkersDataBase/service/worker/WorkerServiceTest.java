package com.WorkersDataBase.service.worker;


import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@ComponentScan(basePackages = "com.WorkersDataBase")
class WorkerServiceTest {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    WorkerPostService underTest;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }
    @Test
    void addWorker_should_return_1(){
        // Given
        Worker worker = existingWorker();
        //  Test
        assertEquals(1, underTest.addWorker(worker, true));
    }
    @Test
    void addWorker_should_return_0(){
        // Given
        Worker worker = getValidWorker();
        //  Test
        assertEquals(0, underTest.addWorker(worker, false));
    }
    @Test
    void addWorker_should_return_minus_1(){
        //  Test
        assertEquals(-1, underTest.addWorker(null, false));
    }
    @Test
    void addWorker_should_return_minus_2(){
        //  Given
        Worker worker = new Worker();
        //  Test
        assertEquals(-2, underTest.addWorker(worker, false));
    }
    @Test
    void addWorker_should_return_minus_3(){
        //  Given
        Worker worker = getValidWorker();
        worker.setPersonalNumber("d2131234321");
        //  Test
        assertEquals(-3, underTest.addWorker(worker, false));
    }
    @Test
    void addWorker_should_return_minus_4(){
        //  Given
        Worker worker = getValidWorker();
        worker.setPersonalNumber("4321");
        //  Test
        assertEquals(-4, underTest.addWorker(worker, false));
    }

    @Test
    void addWorker_should_return_minus_5(){
        // Given
        Worker worker = existingWorker();
        //  Test
        assertEquals(-5, underTest.addWorker(worker, false));
    }
    @Test
    void addWorker_should_return_minus_7(){
        // Given
        Worker worker = getValidWorker();
        worker.setFirstName("D");
        //  Test
        assertEquals(-7, underTest.addWorker(worker, false));
    }
    @Test
    void addWorker_should_return_minus_8(){
        // Given
        Worker worker = getValidWorker();
        worker.setLastName("X");
        //  Test
        assertEquals(-8, underTest.addWorker(worker, false));
    }


    @Test
    void fireWorker_should_return_0(){
        //  Given
        Worker worker = getValidWorker();
        workerRepository.save(worker);

        //  Test
        workerRepository.findAll().forEach(
                worker1 -> assertEquals(0, underTest.fireWorker(worker1.getId()))
        );
    }
    @Test
    void fireWorker_should_return_minus_1(){
        //  Given


        //  Test
        assertEquals(-1, underTest.fireWorker(1L));
    }



    Worker existingWorker(){
        Worker worker = new Worker();
        worker.setFirstName("Daniel");
        worker.setLastName("Xyzzz");
        worker.setPersonalNumber("12312312312");

        Contact contact = new Contact("email@gmail.com");
        contact.setWorker(worker);

        worker.setContact(contact);
        return worker;
    }
    Worker getValidWorker(){
        Worker worker = new Worker();
        worker.setFirstName("Daniel");
        worker.setLastName("Xyzzz");
        worker.setPersonalNumber("54354354354");

        Contact contact = new Contact("avbcs@gmail.com");
        contact.setWorker(worker);

        worker.setContact(contact);
        return worker;
    }
}