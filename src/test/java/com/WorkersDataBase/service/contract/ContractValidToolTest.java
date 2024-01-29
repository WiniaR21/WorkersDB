package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.worker.Worker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ContractValidToolTest {

    private final ContractValidTool underTest = new ContractValidTool();
    @Test
    void validSalary_should_return_true(){
        //  Given
        double salary = 4243;
        //  Test
        assertTrue(underTest.validSalary(salary));
    }
    @Test
    void validSalary_should_return_false(){
        //  Given
        double salary = 4241;
        //  Test
        assertFalse(underTest.validSalary(salary));
    }

    @Test
    void workerHasContract_should_return_true(){
        //  Given
        Worker worker = new Worker();
        worker.setContract(new Contract());
        //  Test
        assertTrue(underTest.workerHasContract(worker));
    }
    @Test
    void workerHasContract_should_return_false(){
        //  Given
        Worker worker = new Worker();
        //  Test
        assertFalse(underTest.workerHasContract(worker));
    }

}