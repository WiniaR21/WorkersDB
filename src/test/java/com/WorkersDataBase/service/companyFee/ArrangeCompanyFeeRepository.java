package com.WorkersDataBase.service.companyFee;

import com.WorkersDataBase.data.companyFee.CompanyFeeRepository;

import static org.mockito.Mockito.when;

public class ArrangeCompanyFeeRepository {
    public static void arrange_repo_count_zero(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.count()).thenReturn(0L);
    }
    public static void arrange_repo_count_one(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.count()).thenReturn(1L);
    }
    public static void arrange_repo_getSumSkladkaEmerytalna_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumSkladkaEmerytalna()).thenReturn(10D);
    }
    public static void arrange_repo_getSumSkladkaRentowa_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumSkladkaRentowa()).thenReturn(10D);
    }
    public static void arrange_repo_getSumUbezpieczenieWypadkowe_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumUbezpieczenieWypadkowe()).thenReturn(10D);
    }
    public static void arrange_repo_getSumFunduszPracy_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumFunduszPracy()).thenReturn(10D);
    }
    public static void arrange_repo_getSumFGSP_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumFGSP()).thenReturn(10D);
    }
    public static void arrange_repo_getSumKosztyPracodawcy_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getSumKosztyPracodawcy()).thenReturn(10D);
    }
    public static void arrange_repo_getAvgCostForWorker_returns_10(CompanyFeeRepository companyFeeRepository){
        when(companyFeeRepository.getAvgCostForWorker()).thenReturn(10D);
    }
}
