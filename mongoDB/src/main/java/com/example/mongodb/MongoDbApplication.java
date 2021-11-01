package com.example.mongodb;

import com.example.mongodb.models.Patient;
import com.example.mongodb.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PatientRepository patientRepository) {

        return args -> {
            Patient patient = new Patient();
            patient.setAge(24);
            patient.setGender("Male");
            patient.setName("Eslam Faisal");
            patientRepository.save(patient);

            List<Patient> patientOptional = patientRepository.limit1("Eslam Faisal", PageRequest.of(0, 1));
            System.out.println(patientOptional);
        };

    }
}
