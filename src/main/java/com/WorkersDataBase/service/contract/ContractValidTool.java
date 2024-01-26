package com.WorkersDataBase.service.contract;


import com.WorkersDataBase.data.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContractValidTool {
    public boolean validSalary(Double salary){
        return salary > 4242;
    }
    public boolean workerHasContract(Worker worker){
        return worker.getContract() != null;
    }
}
