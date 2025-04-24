package com.fernando7492.mindPad;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class hellocontroller {
    @GetMapping("/hello")
    public String hello(){
        return "Hello, mindPad";
    }

}
