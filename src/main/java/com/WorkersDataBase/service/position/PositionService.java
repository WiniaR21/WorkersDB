package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.service.notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final PositionValidTool positionValidTool;
    private final ServicePushNotification notification;

    @Transactional
    public boolean addNewPositionType(String positionName){

        //  Valid
        if(positionValidTool.positionIsNull(positionName)){
            notification.pushUserTryingAddNullPositionInfo();
            return false;
        }
        if (!positionValidTool.positionNameIsUnique(positionName)){
            notification.pushUniquePositionError();
            return false;
        }
        if (!positionValidTool.positionNameIsFine(positionName)){
            notification.pushToShortPositionNameInfo();
            return false;
        }

        //  Do
        Position position = new Position();
        position.setPositionName(positionName);
        positionRepository.save(position);

        notification.pushNewPositionSuccess(positionName);
        return true;
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
