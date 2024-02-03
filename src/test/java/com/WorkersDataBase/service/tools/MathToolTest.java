package com.WorkersDataBase.service.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathToolTest {

    MathTool mathTool;
    @BeforeEach
    void setUp() {
        mathTool = new MathTool();
    }

    @Test
    void testRoundSum(){
        //  Given
        Double roundedSum = mathTool.roundSum(20.511654);
        //  Assert
        assertEquals(20.51,roundedSum);
    }
    @Test
    void testRoundZero(){
        //  Given
        Double roundedSum = mathTool.roundSum(0.001);
        //  Assert
        assertEquals(0.0, roundedSum);
    }
}