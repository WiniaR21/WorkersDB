package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionPostService {
    private final PositionRepository positionRepository;

    /*        STATUS CODE
     *    0 - adding success
     *   -1 - error, positionName is null
     *   -2 - error, positionName is not unique
     *   -3 - error, positionName to short */
    @Transactional
    public int addNewPositionType(String positionName){
        if(nameIsEmpty(positionName))     return -1;
        if(nameIsNotUnique(positionName)) return -2;
        if(nameIsToShort(positionName))   return -3;

        Position position = new Position();
        position.setPositionName(positionName);
        positionRepository.save(position);
        return 0;
    }

    boolean nameIsEmpty(String position) {
        if(position == null) return true;
        return position.isEmpty() || position.isBlank();
    }
    boolean nameIsNotUnique(String positionName){
        return !positionRepository.existsByPositionName(positionName);
    }
    boolean nameIsToShort(String positionName) {
        return positionName.length() <= 4;
    }
}
