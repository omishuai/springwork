package com.shuaih.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {


    //returns the name and present it through the view
    @RequestMapping("/")
    public String showHome() {
        return "index";
    }
}
