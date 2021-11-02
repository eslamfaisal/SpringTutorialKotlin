package com.udacity.course3.reviews.controller

import com.udacity.course3.reviews.entity.Product
import com.udacity.course3.reviews.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpServerErrorException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.system.measureTimeMillis

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
class ProductsController(  // TODO: Wire JPA repositories here
    val productService: ProductService
) {
    /**
     * Creates a product.
     *
     *
     * 1. Accept product as argument. Use [RequestBody] annotation.
     * 2. Save product.
     */
    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct() {
        throw HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED)
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = ["/{id}"])
    fun findById(@PathVariable("id") id: Int?): ResponseEntity<*> {
        throw HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED)
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun listProducts(): List<Product> {
        var list: List<Product> = ArrayList()
        val timeInMillis = measureTimeMillis {
            list = productService.getAllProducts()

        }
        println(timeInMillis)
        return list
    }
}

/**
 * Lists all products.
 *
 * @return The list of products.
 */
@RequestMapping(value = ["/eslam"], method = [RequestMethod.GET])
fun listEslam(): String {
    println("eslam")
    return "Eslam"
}
