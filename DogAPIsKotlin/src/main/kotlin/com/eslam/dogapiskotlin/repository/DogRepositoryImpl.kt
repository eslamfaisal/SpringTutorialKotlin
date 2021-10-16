package com.eslam.dogapiskotlin.repository

import com.eslam.dogapiskotlin.entity.Dog
import com.eslam.dogapiskotlin.service.DogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DogRepositoryImpl : DogService {

    @Autowired
    private lateinit var dogRepository: DogRepository

    override fun retrieveDogs(): List<Dog> {
        return dogRepository.findAll() as List<Dog>
    }

    override fun retrieveDogBreed(): List<String> {
        return dogRepository.findAllBreed()
    }

    override fun retrieveDogBreedById(id: Long): String {
        return dogRepository.findBreedById(id = id)
    }

    override fun retrieveDogNames(): List<String> {
        return dogRepository.findAllName()
    }
}