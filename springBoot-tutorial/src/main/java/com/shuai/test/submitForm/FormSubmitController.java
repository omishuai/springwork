package com.shuai.test.submitForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormSubmitController {

    @PostMapping("/greeting")
    public String submit(@ModelAttribute Greeting greeting) {
        return "result";
    }

    @GetMapping("/greeting")
    public String form(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
}
