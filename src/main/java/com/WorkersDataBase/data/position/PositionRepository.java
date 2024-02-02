package com.WorkersDataBase.data.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
   boolean existsByPositionName(String positionName);
   Optional<Position> getPositionsByPositionName(String positionName);
}
