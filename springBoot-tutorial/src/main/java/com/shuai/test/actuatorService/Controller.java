package com.shuai.test.actuatorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController  //controller and response body
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //data is returned rather than html, jsp or css, as these are static, not returning a view
    // data is converted to json by jackson
    @GetMapping("/greeting")   // same as @RequestMapping(method=GET)
//    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
