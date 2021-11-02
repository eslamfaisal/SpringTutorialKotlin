package com.udacity.course3.reviews.service

import com.udacity.course3.reviews.entity.Product

interface ProductService {

    fun getAllProducts(): List<Product>
    fun saveProduct(product: Product)
}