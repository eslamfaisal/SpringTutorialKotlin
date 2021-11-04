package com.eslam.competitions.domain.category

import javax.persistence.*

@Entity
@Table(name = "questions_categories")
class QuestionCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String? = null
)