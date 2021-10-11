package com.eslam.spring_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.EnableWebMvc

//@EnableWebMvc
@ServletComponentScan
@SpringBootApplication
class SpringKotlinApplication {

}

fun main(args: Array<String>) {
    runApplication<SpringKotlinApplication>(*args)
}

