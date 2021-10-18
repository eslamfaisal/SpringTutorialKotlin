package com.eslam.dogapiskotlin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Dog(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    val name: String? = null,

    val breed: String? = null,

    val origin: String? = null
)