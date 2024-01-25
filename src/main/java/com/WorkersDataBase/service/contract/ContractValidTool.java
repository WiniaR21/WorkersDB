package com.WorkersDataBase.service.contract;


import com.WorkersDataBase.service.validTools.StringValidTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractValidTool {
    public boolean validSalary(Double salary){
        return salary > 4242;
    }
}
