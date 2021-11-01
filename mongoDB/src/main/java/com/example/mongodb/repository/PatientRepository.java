package com.example.mongodb.repository;

import com.example.mongodb.models.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {


    @Query("{name: '?0'}")
    List<Patient> limit1(String name, Pageable pageable);

}
