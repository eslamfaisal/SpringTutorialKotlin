package com.eslam.competitions.domain.answer.entity

import com.eslam.competitions.domain.question.entity.Question
import javax.persistence.*

@Entity
@Table(name = "answer")
class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val number: Int? = null,
    val answer: String? = null,
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    val question: Question? = null,
)