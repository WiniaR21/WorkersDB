package com.WorkersDataBase.service.getService;

import com.WorkersDataBase.data.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerGetService {
    private final WorkerRepository repository;
}
