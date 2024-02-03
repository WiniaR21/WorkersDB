package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerGetService {
    private final WorkerRepository repository;
    private final GetServiceTools tools;

    public Double getAverageAge(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAverageAge());
    }
}
