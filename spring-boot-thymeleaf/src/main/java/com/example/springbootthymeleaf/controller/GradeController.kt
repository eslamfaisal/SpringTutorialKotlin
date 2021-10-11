package com.example.springbootthymeleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class GradeController {
    @RequestMapping("grade")
    fun demo(model: Model): String {
        model.addAttribute("message", "Hello Thymeleaf")
        val grade = 40.5
        model.addAttribute("grade", grade)
        model.addAttribute("GPA", convertGPA(grade))
        // return to templates/demo.html page.

        // return to templates/demo.html page.
        return "grade"
    }


    private fun convertGPA(grade: Double): String {
        return if (grade >= 90) {
            "A"
        } else if (grade < 90 && grade >= 80) {
            "B"
        } else if (grade < 80 && grade >= 70) {
            "C"
        } else if (grade < 70 && grade >= 60) {
            "D"
        } else {
            "F"
        }
    }
}
