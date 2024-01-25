package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.service.Notification.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final ServicePushNotification servicePushNotification;
    private final PositionValidTool positionValidTool;
    //  addNewPositionType returns true if adding was successful
    @Transactional
    public boolean addNewPositionType(String positionName){

        if (positionValidTool.positionNameIsUnique(positionName)){

            Position position = new Position();
            position.setPositionName(positionName);
            positionRepository.save(position);

            servicePushNotification.pushNewPositionSuccess(positionName);
            return true;
        }

        servicePushNotification.pushUniquePositionError();
        return false;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

    //  deletePosition returns true if deleting was successful
    @Transactional
    public boolean deletePosition(Position position){

        if (positionValidTool.someoneHasContract(position)){
            servicePushNotification.pushDeletingPositionConflictInfo();
            return false;
        }

        positionRepository.delete(position);
        servicePushNotification.pushDeletePositionSuccess(position);
        return true;
    }
}
