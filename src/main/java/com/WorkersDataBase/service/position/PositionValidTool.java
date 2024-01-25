package com.WorkersDataBase.service.position;

import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PositionValidTool {
    private final PositionRepository positionRepository;
    private final ContractRepository contractRepository;

    boolean positionNameIsUnique(String positionName){
        return !positionRepository.existsByPositionName(positionName);
    }
    boolean someoneHasContract(Position position){
        return contractRepository.existsByPosition(position);
    }
}
