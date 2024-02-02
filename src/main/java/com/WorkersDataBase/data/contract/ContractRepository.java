package com.WorkersDataBase.data.contract;

import com.WorkersDataBase.data.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByPosition(Position position);
    @Query("SELECT COUNT(contract) FROM Contract contract")
    long count();
    @Query("SELECT AVG(contract.salary) FROM Contract contract")
    Double getAvgSalary();
}
