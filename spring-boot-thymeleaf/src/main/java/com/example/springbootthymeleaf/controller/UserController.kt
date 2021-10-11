package com.example.springbootthymeleaf.controller

import com.example.springbootthymeleaf.models.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest


@Controller
class UserController {

    @RequestMapping("users")
    fun demo2(model: Model): String {
        val lst: MutableList<User> = ArrayList()
        lst.add(User(1, "Tom", 30))
        lst.add(User(2, "Jerry", 29))
        lst.add(User(3, "Nancy", 27))
        model.addAttribute("list", lst)
        return "users_list"
    }

}
