package com.WorkersDataBase.service.worker;

import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import com.WorkersDataBase.service.tools.MathTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerGetService {
    private final WorkerRepository workerRepository;
    private final MathTool tools;

    public Optional<Worker> getById(Long id){
        return workerRepository.findById(id);
    }
    public boolean existById(Long id){
        return workerRepository.existsById(id);
    }
    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }
    public Double getAverageAge(){
        return workerRepository.count() == 0 ? 0 :
                tools.roundSum(workerRepository.getAverageAge());
    }
}
