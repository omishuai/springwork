package com.shuaih.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MyController {


    //returns the name and present it through the view
    @RequestMapping("/")
    public String showHome(HttpSession session) {
        //session exist as long as the user is on the site
        session.setAttribute("name", "Shuai"); // key:value
        // exist in the scope of the broswer
        return "index";
    }


    //returns the name and present it through the view and model
    @RequestMapping("/example")
    public ModelAndView showHome() {
        // create an object with the diplayed view name
        ModelAndView mv = new ModelAndView("index");
        Map<String, Object> model = mv.getModel();

        // here the html format will be shown
        // say, <b>river</b>, then the reviver would be bold
        model.put("name","<br>river");
        // exist in the scope of specific request
        return mv;
    }

    //returns the name and present it through the view
    @RequestMapping("/example2")
    public String showHome(Model model) {
        model.addAttribute("name", "Tiffany");
        return "index";
    }


    @RequestMapping("/test")
    public String showTest() {
        return "test";
    }
}
