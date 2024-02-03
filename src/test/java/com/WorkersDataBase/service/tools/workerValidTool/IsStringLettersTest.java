package com.WorkersDataBase.service.tools.workerValidTool;

import com.WorkersDataBase.service.tools.WorkerValidTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class IsStringLettersTest {
    @InjectMocks
    private WorkerValidTool underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void isStringLetters_should_return_false() {
        // Arrange
        String str = "abc 1";
        //  Assert
        assertFalse(underTest.isStringLetters(str));
    }
    @Test
    void isStringLetters_should_return_true() {
        // Arrange
        String str = "Hello World";
        //  Assert
        assertTrue(underTest.isStringLetters(str));
    }
}