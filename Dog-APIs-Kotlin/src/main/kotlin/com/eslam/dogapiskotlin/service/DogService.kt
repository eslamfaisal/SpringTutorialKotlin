package com.eslam.dogapiskotlin.service

import com.eslam.dogapiskotlin.entity.Dog

interface DogService {
    fun retrieveDogs(): List<Dog>
    fun retrieveDogBreed(): List<String>
    fun retrieveDogBreedById(id: Long): String
    fun retrieveDogNames(): List<String>
}