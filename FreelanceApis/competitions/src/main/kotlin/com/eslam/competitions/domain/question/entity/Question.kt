package com.eslam.competitions.domain.question.entity

import com.eslam.competitions.domain.category.entity.Category
import javax.persistence.*

@Entity
@Table(name = "questions")
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val question: String? = null,
    @Column(name = "right_answer")
    val rightAnswer: Int? = null,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category? = null
)