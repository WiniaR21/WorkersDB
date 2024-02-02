package com.WorkersDataBase.data.contract.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    boolean existsByPesel(String pesel);

    @Query("SELECT COUNT(worker) FROM Worker worker")
    long count();
    @Query("SELECT AVG(worker.age) FROM Worker worker")
    Double getAverageAge();
}
