package com.eslam.spring_kotlin

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.io.IOException
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.annotation.WebListener
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "helloServlet", urlPatterns = ["/helloServlet"])
class HelloServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        println("Running Hello Servlet doGet method = ${request.cookies.size}")
    }

}
@WebServlet(name = "", urlPatterns = ["/"])
class IndexServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        println("Running Hello Servlet doGet method = ${request.cookies.size}")
    }

    @GetMapping
    fun index(model: Model?): String {
        return "index"
    }
}

@WebFilter(filterName = "helloFilter", urlPatterns = ["/helloServlet"])
class HelloFilter : Filter {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(
        servletRequest: ServletRequest?,
        servletResponse: ServletResponse?, filterChain: FilterChain
    ) {
        println("Executing doFilter method")
        filterChain.doFilter(servletRequest, servletResponse)
        println("Done executing doFilter method")
    }
}

@WebListener
class HelloListener : ServletContextListener {

    override fun contextInitialized(servletContextEvent: ServletContextEvent) {
        println("Servlet Context Initialized")
    }

    override fun contextDestroyed(servletContextEvent: ServletContextEvent) {
        println("Servlet Context Destroyed")
    }

}
