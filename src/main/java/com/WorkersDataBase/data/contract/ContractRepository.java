package com.WorkersDataBase.data.contract;

import com.WorkersDataBase.data.contract.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByPosition(Position position);
}
