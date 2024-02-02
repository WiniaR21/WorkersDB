package com.WorkersDataBase.data;


import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.position.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestDataConfiguration {
   Position pracownikProdukcji;
   Position lider;
   Position operatorWozka;
   Position operatorMaszyn;


    @Bean
    CommandLineRunner commandLineRunner( PositionRepository positionRepository){
        return args -> {
            createPosition(positionRepository);
        };

    }
    void createPosition(PositionRepository positionRepository){
        pracownikProdukcji = new Position();
        pracownikProdukcji.setPositionName("Pracownik Produkcji");
        positionRepository.save(pracownikProdukcji);

        lider = new Position();
        lider.setPositionName("Lider");
        positionRepository.save(lider);

        operatorWozka = new Position();
        operatorWozka.setPositionName("Operator wózka");
        positionRepository.save(operatorWozka);

        operatorMaszyn = new Position();
        operatorMaszyn.setPositionName("Operator maszyn");
        positionRepository.save(operatorMaszyn);
    }

}
