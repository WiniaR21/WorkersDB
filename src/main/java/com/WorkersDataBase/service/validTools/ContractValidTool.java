package com.WorkersDataBase.service.validTools;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractValidTool {
    private final StringValidTool stringValidTool;

    public boolean validPositionName(String positionName){
        return stringValidTool.isStringLetters(positionName) && positionName.length() > 4;
    }
    public boolean validSalary(Double salary){
        return salary > 4242;
    }

}
