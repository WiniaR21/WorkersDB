package com.WorkersDataBase.data.contract.companyFee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyFeeRepository extends JpaRepository<CompanyFee, Long> {
    @Override
    @Query("SELECT COUNT(cf) FROM CompanyFee cf")
    long count();
    @Query("SELECT SUM(cf.skladkaEmerytalna) FROM CompanyFee cf")
    Double getSumSkladkaEmerytalna();
    @Query("SELECT SUM(cf.skladkaRentowa) FROM CompanyFee cf")
    Double getSumSkladkaRentowa();
    @Query("SELECT SUM(cf.skladkaNaUbezpieczenieWypadkowe) FROM CompanyFee cf")
    Double getSumUbezpieczenieWypadkowe();
    @Query("SELECT SUM(cf.skladkaNaFunduszPracy) FROM CompanyFee cf")
    Double getSumFunduszPracy();
    @Query("SELECT SUM(cf.skladkaNaFGSP) FROM CompanyFee cf")
    Double getSumFGSP();
    @Query("SELECT SUM(cf.laczneKosztyPracodawcy) FROM CompanyFee cf")
    Double getSumKosztyPracodawcy();
}
