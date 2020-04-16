package com.shuai.test.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller  //controller and response body
public class InitController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //data is returned rather than html, jsp or css, as these are static, not returning a view
    // data is converted to json by jackson
    @GetMapping("/")   // same as @RequestMapping(method=GET)
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
