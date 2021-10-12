package com.example.springbootvalidation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("add")
    public String toAdd(User user) {
        return "add";
    }

    @RequestMapping("addUser")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Save user error =" + result.getAllErrors());
            result.getAllErrors().forEach(objectError -> {
                logger.error(objectError.getObjectName());
            });
            return "add";
        }
        System.out.println("Save user =" + user);
        return "success";
    }
}
