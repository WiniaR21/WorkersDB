package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.companyFee.CompanyFeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyFeeGetService {
    private final CompanyFeeRepository repository;

    public Double getSumSkladkaEmerytalna(){

        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumSkladkaEmerytalna());
    }
    public Double getSumSkladkaRentowa(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumSkladkaRentowa());
    }
    public Double getSumUbezpieczenieWypadkowe(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumUbezpieczenieWypadkowe());
    }
    public Double getSumFunduszPracy(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumFunduszPracy());
    }
    public Double getSumFGSP(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumFGSP());
    }
    public Double getSumKosztyPracodawcy(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getSumKosztyPracodawcy());
    }
    public Double getAvgCostForWorker(){
        return impossibleToCalculate() ? 0 :
                roundSum(repository.getAvgCostForWorker());
    }
    private boolean impossibleToCalculate(){
        return repository.count() == 0;
    }
    private Double roundSum(Double sum){
        return Math.round(sum * 100.0) / 100.0;
    }
}
