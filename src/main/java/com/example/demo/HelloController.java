package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";  // loads index.html
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";  // loads hello.html
    }
}
