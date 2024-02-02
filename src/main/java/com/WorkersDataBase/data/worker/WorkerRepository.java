package com.WorkersDataBase.data.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    boolean existsByPesel(String pesel);

    @Query("SELECT COUNT(worker) FROM Worker worker")
    long count();
    @Query("SELECT AVG(worker.age) FROM Worker worker")
    Double getAverageAge();
}
