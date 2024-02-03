package com.WorkersDataBase.service.contract.contractGetService;

import com.WorkersDataBase.data.contract.ContractRepository;

import static org.mockito.Mockito.when;

public class ArrangeContractRepository {
    public static void arrange_contract_repo_count_zero(ContractRepository contractRepository){
        when(contractRepository.count()).thenReturn(0L);
    }
    public static void arrange_contract_repo_count_one(ContractRepository contractRepository){
        when(contractRepository.count()).thenReturn(1L);
    }
    public static void arrange_contract_repo_getAvgGrossSalary_returns_10(ContractRepository contractRepository){
        when(contractRepository.getAvgSalary()).thenReturn(10D);
    }
}
