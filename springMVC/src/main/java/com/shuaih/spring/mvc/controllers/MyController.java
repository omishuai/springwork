package com.shuaih.spring.mvc.controllers;

import com.shuaih.spring.mvc.db.Profile;
import com.shuaih.spring.mvc.service.ProfileService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MyController {


    private ProfileService pservice;
    public ProfileService getPservice() {
        return pservice;
    }
    @Autowired
    public void setPservice(ProfileService pservice) {
        this.pservice = pservice;
    }


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

    @RequestMapping("/test2")
    public String test(Model model) {
        List<Profile> profiles = pservice.getCurrent();
        model.addAttribute("name",profiles);
        return "test2";
    }


    @RequestMapping(value ="/profile", method = RequestMethod.GET)
    public String showProfile(Model model, @RequestParam("id") String id) {
        System.out.println("passed-in param: " + id);
        return "index";
    }
}
