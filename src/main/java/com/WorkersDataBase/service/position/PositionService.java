package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.contract.Position;
import com.WorkersDataBase.data.contract.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    //  addNewPositionType returns true if adding was successful
    public boolean addNewPositionType(String name){
        Position position = new Position();
        position.setPositionName(name);
        positionRepository.save(position);
        return true;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

    @Transactional
    public void deletePosition(Position position){

        positionRepository.delete(position);
    }
}
