package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PositionValidToolTest {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private PositionRepository positionRepository;
    private PositionValidTool underTest;

    @BeforeEach
    void setUp() {
        underTest = new PositionValidTool(positionRepository, contractRepository);
    }

    @AfterEach
    void tearDown() {
        contractRepository.deleteAll();
        positionRepository.deleteAll();
    }

    //  positionNameIsUnique(String positionName)
    @Test
    void positionNameIsUnique_by_string_should_return_true(){
        //  Given
        Position position = new Position();
        position.setPositionName("Lider");
        //  Test
        assertTrue(underTest.positionNameIsUnique(position.getPositionName()));
    }
    @Test
    void  positionNameIsUnique_by_string_should_return_false(){
        //  Given
        Position position = new Position();
        position.setPositionName("Lider");
        positionRepository.save(position);
        // Test
        assertFalse(underTest.positionNameIsUnique(position.getPositionName()));
    }
    //  someoneHasContract(Position position)
    @Test
    void someoneHasContract_should_return_true(){
        //  Given
        Contract contract = new Contract();
        Position position = new Position();
        contract.setPosition(position);

        contractRepository.save(contract);
        positionRepository.save(position);

        //  Test
        assertTrue(underTest.someoneHasContract(position));
    }
    @Test()
    void someoneHasContract_should_return_false(){
        //  Given
        Contract contract = new Contract();
        Position position = new Position();
        contractRepository.save(contract);
        positionRepository.save(position);
        //  Test
        assertFalse(underTest.someoneHasContract(position));

    }

    //  positionIsNull(Position position)
    @Test
    void positionIsNull_by_position_should_return_true() {
        //  Given
        Contract contract = new Contract();
        //  Test
        assertTrue(underTest.positionIsNull(contract.getPosition()));
    }
    @Test
    void positionIsNull_by_position_should_return_false(){
        //  Given
        Position position = new Position();
        position.setPositionName("Lider");
        //  Test
        assertFalse(underTest.positionIsNull(position));
    }

    //  positionIsNull(String position)
    @Test
    void positionIsNull_by_string_should_return_true(){
        //  Given
        Position position = new Position();
        //  Test
        assertTrue(underTest.positionIsNull(position.getPositionName()));
    }
    @Test
    void positionIsNull_by_string_should_return_false(){
        //  Given
        String positionName = "Lider";
        //  Test
        assertFalse(underTest.positionIsNull(positionName));
    }

    //  positionNameIsFine(String positionName)
    @Test
    void positionNameIsFine_should_return_true(){
        //  Given
        String positionName = "abcde";
        //  Test
        assertTrue(underTest.positionNameIsFine(positionName));
    }
    @Test
    void positionNameIsFine_should_return_false(){
        //  Given
        String positionName = "abcd";
        //  Test
        assertFalse(underTest.positionNameIsFine(positionName));
    }

}