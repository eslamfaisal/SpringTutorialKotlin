package com.example.springbootexception.exeptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class RoleController {

//    @ExceptionHandler(value = {ArithmeticException.class})
//    public ModelAndView handlerArithmeticException(Exception e) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("mathError");
//        return modelAndView;
//    }
}
