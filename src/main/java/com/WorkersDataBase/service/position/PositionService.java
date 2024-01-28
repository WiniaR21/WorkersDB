package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final PositionValidTool positionValidTool;
    private final ServicePushNotification notification;

    /*
    *   RETURN CODE
    *    0 - adding success
    *   -1 - error, positionName is null
    *   -2 - error, positionName is not unique
    *   -3 - error, positionName to short
    */
    @Transactional
    public int addNewPositionType(String positionName){

        //  Valid
        if(positionValidTool.positionIsNull(positionName)) return -1;
        if(!positionValidTool.positionNameIsUnique(positionName)) return -2;
        if(!positionValidTool.positionNameIsFine(positionName)) return -3;
        
        //  Do
        Position position = new Position();
        position.setPositionName(positionName);
        positionRepository.save(position);
        return 0;
    }

    @Transactional
    public boolean deletePosition(Position position){

        //  Valid
        if(positionValidTool.positionIsNull(position)){
            notification.pushError();
            return false;
        }

        if (positionValidTool.someoneHasContract(position)){
            notification.pushDeletingPositionConflictInfo();
            return false;
        }
        //  Do
        positionRepository.delete(position);
        notification.pushDeletePositionSuccess(position);
        return true;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

}
