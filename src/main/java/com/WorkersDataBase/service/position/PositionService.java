package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import com.WorkersDataBase.service.ServicePushNotification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final ContractRepository contractRepository;
    private final ServicePushNotification servicePushNotification;

    //  addNewPositionType returns true if adding was successful
    @Transactional
    public boolean addNewPositionType(String positionName){
        boolean positionNameIsUnique = !positionRepository.existsByPositionName(positionName);

        if (positionNameIsUnique){
            Position position = new Position();
            position.setPositionName(positionName);
            positionRepository.save(position);

            servicePushNotification.pushSuccess("Dodano stanowisko " + positionName + ".");
            return true;
        }

        servicePushNotification.pushError("Stanowisko powinno mieć unikalną nazwę.");
        return false;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

    //  deletePosition returns true if deleting was successful
    @Transactional
    public boolean deletePosition(Position position){
        boolean someoneHasContractWithThisPosition =
                contractRepository.existsByPosition(position);

        if (someoneHasContractWithThisPosition){
            servicePushNotification.pushError("Ktoś ma to stanowisko na umowie. Najpierw rozwiąż ten problem.");
            return false;
        }

        positionRepository.delete(position);
        servicePushNotification.pushSuccess("Usunięto stanowisko " + position.getPositionName() + ".");
        return true;
    }
}
