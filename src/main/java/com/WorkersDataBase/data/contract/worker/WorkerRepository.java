package com.WorkersDataBase.data.contract.worker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    boolean existsByPesel(String pesel);
    Optional<Worker> findByPesel(String pesel);
}
