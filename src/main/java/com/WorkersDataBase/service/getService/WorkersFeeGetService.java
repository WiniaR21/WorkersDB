package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.workersFee.WorkersFeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkersFeeGetService {
    private final WorkersFeeRepository repository;
}
