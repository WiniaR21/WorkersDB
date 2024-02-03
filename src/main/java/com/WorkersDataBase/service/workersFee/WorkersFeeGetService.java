package com.WorkersDataBase.service.workersFee;

import com.WorkersDataBase.data.workersFee.WorkersFeeRepository;
import com.WorkersDataBase.service.tools.MathTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkersFeeGetService {
    private final WorkersFeeRepository repository;
    private final MathTool tools;
    public Double getAvgNetSalary(){
        return repository.count() == 0 ? 0 :
                tools.roundSum(repository.getAvgNetSalary());
    }
}
