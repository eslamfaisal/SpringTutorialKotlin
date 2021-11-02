package com.udacity.course3.reviews.repository

import com.udacity.course3.reviews.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Int>