package com.WorkersDataBase.data.workersFee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersFeeRepository extends JpaRepository<WorkersFee, Long> {
    @Override
    @Query("SELECT COUNT(workersFee) FROM WorkersFee workersFee")
    long count();
    @Query("SELECT AVG(workersFee.kwotaDoWyplatyDlaPracownika) FROM WorkersFee workersFee")
    Double getAvgNetSalary();
}
