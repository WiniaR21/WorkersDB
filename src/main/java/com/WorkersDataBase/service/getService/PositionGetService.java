package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionGetService {
    private final PositionRepository repository;
}
