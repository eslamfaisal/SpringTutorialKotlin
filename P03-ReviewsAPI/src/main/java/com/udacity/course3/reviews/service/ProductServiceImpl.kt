package com.udacity.course3.reviews.service

import com.udacity.course3.reviews.entity.Product
import com.udacity.course3.reviews.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {


    override fun getAllProducts(): List<Product> {
        return productRepository.findAll() as List<Product>
    }

    override fun saveProduct(product: Product) {
        productRepository.save(product)
    }
}