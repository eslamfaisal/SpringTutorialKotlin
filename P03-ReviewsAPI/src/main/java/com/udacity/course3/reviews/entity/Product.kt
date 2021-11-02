package com.udacity.course3.reviews.entity

import javax.persistence.*

@Entity
@Table(name = "product")
class Product(
    @Id
    val id: Int = 0,
    val price: Float = 0f,
    val name: String? = null,
    val description: String? = null,

)