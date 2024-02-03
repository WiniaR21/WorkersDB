package com.WorkersDataBase.service.companyFee;

import com.WorkersDataBase.data.companyFee.CompanyFeeRepository;
import com.WorkersDataBase.service.tools.MathTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyFeeGetService {
    private final CompanyFeeRepository repository;
    private final MathTool tools;

    public Double getSumSkladkaEmerytalna(){

        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumSkladkaEmerytalna());
    }
    public Double getSumSkladkaRentowa(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumSkladkaRentowa());
    }
    public Double getSumUbezpieczenieWypadkowe(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumUbezpieczenieWypadkowe());
    }
    public Double getSumFunduszPracy(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumFunduszPracy());
    }
    public Double getSumFGSP(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumFGSP());
    }
    public Double getSumKosztyPracodawcy(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getSumKosztyPracodawcy());
    }
    public Double getAvgCostForWorker(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAvgCostForWorker());
    }
}
