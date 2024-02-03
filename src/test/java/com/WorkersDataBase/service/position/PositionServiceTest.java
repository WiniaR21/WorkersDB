package com.WorkersDataBase.service.position;


import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
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
@ComponentScan
class PositionServiceTest {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private PositionPostService underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        workerRepository.deleteAll();
        contractRepository.deleteAll();
        positionRepository.deleteAll();
    }
    @Test
    void xd(){
    }
}
