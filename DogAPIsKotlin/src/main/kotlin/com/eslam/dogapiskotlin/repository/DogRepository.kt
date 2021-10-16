package com.eslam.dogapiskotlin.repository

import com.eslam.dogapiskotlin.entity.Dog
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface DogRepository : CrudRepository<Dog?, Long?> {

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    fun findBreedById(id: Long): String

    @Query("select d.id, d.breed from Dog d")
    fun findAllBreed(): List<String>

    @Query("select d.id, d.name from Dog d")
    fun findAllName(): List<String>


}