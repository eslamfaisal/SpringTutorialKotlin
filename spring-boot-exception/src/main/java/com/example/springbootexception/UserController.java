package com.example.springbootexception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/add")
    public String add(Model model) {
        try {

        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage());
        }
        int num = 10 / 0;
        return "add";
    }

    @RequestMapping("/nullView")
    public String nullView(Model model) {
        String eslam = null;
        String b = eslam.toLowerCase();
        return "add";
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("mathError");
        return modelAndView;
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handlerNullPointerException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("nullPointerException");
        return modelAndView;
    }

}
