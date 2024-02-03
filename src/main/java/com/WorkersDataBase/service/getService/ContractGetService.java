package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.contract.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractGetService {
    private final ContractRepository repository;
    private final GetServiceTools tools;
    public Double getAvgGrossSalary(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAvgSalary());
    }
}
