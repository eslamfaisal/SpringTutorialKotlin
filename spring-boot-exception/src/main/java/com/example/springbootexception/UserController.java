package com.example.springbootexception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    public UserController(Hazem user) {
        this.user = user;
    }

    @RequestMapping("/add")
    public String add() {
//        try {
//
//        } catch (Exception e) {
//            model.addAttribute("exception", e.getMessage());
//        }
//        int num = 10 / 0;
        return "add";
    }

    private final Hazem user;

    @RequestMapping("/nullView")
    public String nullView(Model model) {

        System.out.println(user.getHazem());
        return "add";
    }
//
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView handlerArithmeticException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("mathError");
//        return modelAndView;
//    }
//
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView handlerNullPointerException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("nullPointerException");
//        return modelAndView;
//    }

}
