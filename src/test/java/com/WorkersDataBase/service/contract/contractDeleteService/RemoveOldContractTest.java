package com.WorkersDataBase.service.contract.contractDeleteService;

import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.contract.ContractDeleteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RemoveOldContractTest {
    @Mock
    private WorkerRepository workerRepository;
    @Mock
    private PositionRepository positionRepository;
    @InjectMocks
    private ContractDeleteService underTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test()
    void removeOldContract_should_threw_illegal_argument_exception() {
        Worker worker = new Worker();
        assertThrows(IllegalArgumentException.class, () -> underTest.removeOldContract(worker));
    }
}