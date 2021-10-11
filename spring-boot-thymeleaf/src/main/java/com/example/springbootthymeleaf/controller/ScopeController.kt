package com.example.springbootthymeleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
class ScopeController {

    @RequestMapping("scope")
    fun demo3(request: HttpServletRequest, model: Model?): String? {
        // Request
        request.setAttribute("request", "request data")
        // Session
        request.session.setAttribute("session", "session id = ${request.session.id}")

        // Application
        request.session.servletContext.setAttribute("application", "application data")
        return "scope"
    }
}
