package edu.udacity.java.nano;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class WebSocketChatApplication {

    @Value("${app.websocket.url}")
    private String websocketUrl;

    public static void main(String[] args) {
        SpringApplication.run(WebSocketChatApplication.class, args);
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
    public ModelAndView index(String username, HttpServletRequest request) {
        if (username == null || username.trim().isEmpty()) {
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("websocketUrl", websocketUrl);
        mv.setViewName("/chat");
        return mv;
    }
}
