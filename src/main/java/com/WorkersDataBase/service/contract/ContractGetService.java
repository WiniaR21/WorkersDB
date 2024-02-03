package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.service.tools.MathTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractGetService {
    private final ContractRepository repository;
    private final MathTool tools;
    public Double getAvgGrossSalary(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAvgSalary());
    }
}
