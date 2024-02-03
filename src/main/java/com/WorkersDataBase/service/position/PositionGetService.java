package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionGetService {
    private final PositionRepository positionRepository;
    public List<Position> getPositions(){
        return positionRepository.findAll();
    }
}
