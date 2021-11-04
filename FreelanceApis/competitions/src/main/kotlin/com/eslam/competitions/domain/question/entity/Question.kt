package com.eslam.competitions.domain.question.entity

import com.eslam.competitions.domain.category.QuestionCategory
import javax.persistence.*

@Entity
@Table(name = "questions")
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val question: String? = null,
    @Column(name = "right_answer")
    val rightAnswer: Boolean? = null,
    val category: QuestionCategory ?= null
)