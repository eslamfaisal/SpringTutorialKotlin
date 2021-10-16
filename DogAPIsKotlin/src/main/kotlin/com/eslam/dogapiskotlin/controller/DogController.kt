package com.eslam.dogapiskotlin.controller

import com.eslam.dogapiskotlin.entity.Dog
import com.eslam.dogapiskotlin.service.DogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DogController {

    @Autowired
    final lateinit var dogService: DogService

    @GetMapping("/dogs")
    fun getAllDogs(): ResponseEntity<List<Dog>> {
        val list: List<Dog> = dogService.retrieveDogs()
        return ResponseEntity<List<Dog>>(list, HttpStatus.OK)
    }

    @GetMapping("/dog", params = ["eslam"])
    fun getBreedById(@PathVariable(value = "eslam") id: Long): ResponseEntity<String> {
        val breed: String = dogService.retrieveDogBreedById(id)
        return ResponseEntity<String>(breed, HttpStatus.OK)
    }
}