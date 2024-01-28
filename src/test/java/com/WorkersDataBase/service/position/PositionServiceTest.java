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
    private PositionService underTest;

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
    void addNewPositionType_should_return_0() {
        //  Given
        String positionName = "Lider";
        //  Test
        assertEquals(0, underTest.addNewPositionType(positionName));
        assertTrue(positionRepository.existsByPositionName(positionName));
    }
    @Test
    void addNewPositionType_should_return_minus_1() {
        //  Test
        assertEquals(-1, underTest.addNewPositionType(null));
    }
    @Test
    void addNewPositionType_should_return_minus_2() {
        //  Given
        Position position = new Position();
        position.setPositionName("Lider");
        positionRepository.save(position);

        //  Test
        assertEquals(-2, underTest.addNewPositionType(position.getPositionName()));
    }
    @Test
    void addNewPositionType_should_return_minus_3() {
        //  Given
        String positionName = "Lide";
        //  Test
        assertEquals(-3, underTest.addNewPositionType(positionName));
    }

    @Test
    void deletePosition_should_return_0(){
        //  Given
        Position position = new Position();
        position.setPositionName("Lider");
        positionRepository.save(position);
        //  Test
        assertEquals(0, underTest.deletePosition(position));
        assertFalse(positionRepository.existsByPositionName("Lider"));
    }
    @Test
    void deletePosition_should_return_minus_1(){
        //  Test
        assertEquals(-1, underTest.deletePosition(null));
    }
    @Test
    void deletePosition_should_return_minus_2(){
        //  Given
        Worker worker = getValidWorker();

        Position position = new Position();
        position.setPositionName("Lider");

        Contract contract = new Contract();
        contract.setPosition(position);
        contract.setWorker(worker);

        contractRepository.save(contract);
        workerRepository.save(worker);
        positionRepository.save(position);


        //  Test
        assertEquals(-2, underTest.deletePosition(position));
    }
    Worker getValidWorker(){
        Worker worker = new Worker();
        worker.setFirstName("Daniel");
        worker.setLastName("Xyzzz");
        worker.setPesel("12312312312");

        Contact contact = new Contact("email@gmail.com");
        contact.setWorker(worker);
        worker.setContact(contact);

        return worker;
    }
}