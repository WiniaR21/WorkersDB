package com.WorkersDataBase.service.companyFee;

import com.WorkersDataBase.service.tools.MathTool;

import static org.mockito.Mockito.when;

public class ArrangeMathTools {
    public static void arrange_math_tool_returns_10(MathTool tool){
        Double number = 10D;
        when(tool.roundSum(number)).thenReturn(20D);
    }
}
