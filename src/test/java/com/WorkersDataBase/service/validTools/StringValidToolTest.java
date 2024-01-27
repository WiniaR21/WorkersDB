package com.WorkersDataBase.service.validTools;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringValidToolTest {
    private final StringValidTool underTest = new StringValidTool();

    @AfterEach
    void tearDown() {

    }
    @Test
    void isStringLetters_should_return_true() {
        //  Given
        String string  = "XY z ąćłóżęń";
        //  Test
        assertTrue(underTest.isStringLetters(string));
    }
    @Test
    void isStringLetters_should_return_false() {
        //  Given
        String string = "XY z ąćłóżęń1";
        //  Test
        assertFalse(underTest.isStringLetters(string));
    }

    @Test
    void isStringDigits_should_return_true(){
        //  Given
        String string = "0123456789";
        //  Test
        assertTrue(underTest.isStringDigits(string));
    }
    @Test
    void isStringDigits_should_return_false(){
        //  Given
        String string = "0123456789a";
        //  Test
        assertFalse(underTest.isStringDigits(string));
    }


}