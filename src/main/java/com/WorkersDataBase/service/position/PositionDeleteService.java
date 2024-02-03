package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionDeleteService {
    private final PositionRepository positionRepository;
    private final ContractRepository contractRepository;

    /*        STATUS CODE
     *    0 - removing success
     *   -1 - error, position is null
     *   -2 - error, someone has contract with this position */
    @Transactional
    public int deletePosition(Position position){
        if(position == null)             return -1;
        if(someoneHasContract(position)) return -2;

        positionRepository.delete(position);
        return 0;
    }

    boolean someoneHasContract(Position position) {
       return contractRepository.existsByPosition(position);
    }

}
