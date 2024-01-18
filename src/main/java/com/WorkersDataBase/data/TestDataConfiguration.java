package com.WorkersDataBase.data;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.contract.Contract;
import com.WorkersDataBase.data.contract.ContractRepository;
import com.WorkersDataBase.data.contract.Position;
import com.WorkersDataBase.data.contract.PositionRepository;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.worker.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestDataConfiguration {
   Position pracownikProdukcji;
   Position lider;

   Worker daniel = new Worker();
   Worker kuba = new Worker();

    @Bean
    CommandLineRunner commandLineRunner(WorkerRepository workerRepository, PositionRepository positionRepository, ContractRepository contractRepository){
        return args -> {
            createPosition(positionRepository);
            createWorkers(workerRepository);
            createContract(contractRepository, workerRepository);

        };

    }
    void createPosition(PositionRepository positionRepository){
        pracownikProdukcji = new Position();
        pracownikProdukcji.setPositionName("Pracownik Produkcji");
        positionRepository.save(pracownikProdukcji);

        lider = new Position();
        lider.setPositionName("Lider");
        positionRepository.save(lider);
    }

    void createWorkers(WorkerRepository workerRepository){
        daniel.setPesel("12312312312");
        daniel.setFirstName("Daniel");
        daniel.setLastName("Winiarczyk");

        Contact contact = new Contact("Dada@gmail.com");
        daniel.setContact(contact);

        //=============================

        kuba.setPesel("75756745312");
        kuba.setFirstName("Kuba");
        kuba.setLastName("Jakistam");

        Contact contact1 = new Contact("fbbxcdasdasa@gmail.com");
        kuba.setContact(contact1);


        workerRepository.saveAll(List.of(daniel,kuba));
    }
    void createContract(ContractRepository contractRepository,WorkerRepository workerRepository){
        Contract danielsContract = new Contract();
        danielsContract.setWorker(daniel);
        danielsContract.setPosition(lider);
        danielsContract.setSalary(4000.0);

        Worker workerer = new Worker();
        // TODO naprawić dodawanie kontrakru do worker

        //workerRepository.findByPesel(daniel.getPesel()).ifPresent(worker -> workerer = worker);


        Contract kubaContract = new Contract();
        kubaContract.setWorker(kuba);
        kubaContract.setPosition(pracownikProdukcji);
        kubaContract.setSalary(3000.0);
        workerRepository.findByPesel(kuba.getPesel()).ifPresent(worker -> worker.setContract(kubaContract));

        contractRepository.saveAll(List.of(danielsContract, kubaContract));


    }
}
