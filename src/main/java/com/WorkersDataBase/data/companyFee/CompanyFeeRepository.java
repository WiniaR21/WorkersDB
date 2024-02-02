package com.WorkersDataBase.data.companyFee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyFeeRepository extends JpaRepository<CompanyFee, Long> {
    @Override
    @Query("SELECT COUNT(companyFee) FROM CompanyFee companyFee")
    long count();
    @Query("SELECT SUM(companyFee.skladkaEmerytalna) FROM CompanyFee companyFee")
    Double getSumSkladkaEmerytalna();
    @Query("SELECT SUM(companyFee.skladkaRentowa) FROM CompanyFee companyFee")
    Double getSumSkladkaRentowa();
    @Query("SELECT SUM(companyFee.skladkaNaUbezpieczenieWypadkowe) FROM CompanyFee companyFee")
    Double getSumUbezpieczenieWypadkowe();
    @Query("SELECT SUM(companyFee.skladkaNaFunduszPracy) FROM CompanyFee companyFee")
    Double getSumFunduszPracy();
    @Query("SELECT SUM(companyFee.skladkaNaFGSP) FROM CompanyFee companyFee")
    Double getSumFGSP();
    @Query("SELECT SUM(companyFee.laczneKosztyPracodawcy) FROM CompanyFee companyFee")
    Double getSumKosztyPracodawcy();
    @Query("SELECT AVG(companyFee.laczneKosztyPracodawcy) FROM CompanyFee companyFee")
    Double getAvgCostForWorker();
}
