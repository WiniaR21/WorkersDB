package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final PositionValidTool positionValidTool;


    @Transactional
    public int addNewPositionType(String positionName){
        /*
         *   ERROR CODE
         *    0 - adding success
         *   -1 - error, positionName is null
         *   -2 - error, positionName is not unique
         *   -3 - error, positionName to short
         */
        //  Valid
        if( positionValidTool.positionIsNull(positionName))       return -1;
        if(!positionValidTool.positionNameIsUnique(positionName)) return -2;
        if(!positionValidTool.positionNameIsFine(positionName))   return -3;

        //  Do
        Position position = new Position();
        position.setPositionName(positionName);
        positionRepository.save(position);
        return 0;
    }


    @Transactional
    public int deletePosition(Position position){
        /*
         *   RETURN CODE
         *    0 - removing success
         *   -1 - error, position is null
         *   -2 - error, someone has contract with this position
         */
        //  Valid
        if(positionValidTool.positionIsNull(position))     return -1;
        if(positionValidTool.someoneHasContract(position)) return -2;

        //  Do
        positionRepository.delete(position);
        return 0;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

}
