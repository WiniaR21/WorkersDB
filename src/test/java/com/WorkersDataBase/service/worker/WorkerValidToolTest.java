package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.contact.ContactRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
    void workerNoSpecialSymbols_should_return_true() {
        System.out.println("xd");
    }
}