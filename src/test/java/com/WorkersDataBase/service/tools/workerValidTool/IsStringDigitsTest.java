package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class IsStringDigitsTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void isStringDigits_should_return_false_case_a() {
        //  Arrange
        String str = "abc 1";
        //  Assert
        assertFalse(underTest.isStringDigits(str));
    }
    @Test
    void isStringDigits_should_return_false_case_b() {
        //  Arrange
        String str = "123 4";
        //  Assert
        assertFalse(underTest.isStringDigits(str));
    }
    @Test
    void isStringDigits_should_return_true() {
        //  Arrange
        String str = "1234";
        //  Assert
        assertTrue(underTest.isStringDigits(str));
    }

}