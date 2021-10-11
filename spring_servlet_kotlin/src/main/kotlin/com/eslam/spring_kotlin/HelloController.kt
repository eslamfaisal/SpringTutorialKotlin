package com.eslam.spring_kotlin

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    private val result: MutableMap<String, Any> = HashMap()

    @RequestMapping("/hello")
    fun hello(): Map<String, Any> {
        result["name"] = "Stephen"
        result["city"] = "San Jose"
        return result
    }
}
