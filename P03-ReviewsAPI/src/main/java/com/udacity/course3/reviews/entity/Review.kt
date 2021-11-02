package com.udacity.course3.reviews.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "review")
class Review(

    @Id val id: Int? = 0,
    val title: String? = null,
    val review_text: String? = null,
    val created_ts: Timestamp? = null,
    val recommended: Int? = 0,

    @ManyToOne
    val product: Product? = null,
)