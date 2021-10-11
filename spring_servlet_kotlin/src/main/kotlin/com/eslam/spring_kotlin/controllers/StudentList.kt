package com.eslam.spring_kotlin.controllers

import com.eslam.spring_kotlin.models.Student
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class StudentList {

    @RequestMapping("/list")
    fun list(model: Model): String {
        val list: MutableList<Student> = ArrayList()
        list.add(Student(1, "Tom", 80.5))
        list.add(Student(2, "Jerry", 90.4))
        list.add(Student(3, "Paul", 77.5))
        model.addAttribute("list", list)
        return "../templates/list.html"
    }
}
