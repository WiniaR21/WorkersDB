package com.WorkersDataBase.service.workersFee;

import com.WorkersDataBase.data.workersFee.WorkersFeeRepository;
import com.WorkersDataBase.service.tools.GetServiceTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkersFeeGetService {
    private final WorkersFeeRepository repository;
    private final GetServiceTools tools;
    public Double getAvgNetSalary(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAvgNetSalary());
    }
}
