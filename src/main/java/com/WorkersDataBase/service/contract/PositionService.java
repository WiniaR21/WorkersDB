package com.WorkersDataBase.service.contract;

import com.WorkersDataBase.data.contract.Position;
import com.WorkersDataBase.data.contract.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public boolean addNewPositionType(String name){
        Position position = new Position();
        position.setPositionName(name);
        positionRepository.save(position);
        return true;
    }
}
