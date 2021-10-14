package com.eslam.chatbotspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class ChatBotSpringApplication {

    @Resource
    ServerEndpointExporter serverEndpointExporter;

    public static void main(String[] args) {
        SpringApplication.run(ChatBotSpringApplication.class, args);
    }

    /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * Chatroom Page
     */
    @GetMapping("/index")
    public ModelAndView index(String username, HttpServletRequest request) throws UnknownHostException {

        System.out.println("username" + username);
        if (username == null || username.trim().isEmpty()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
}
