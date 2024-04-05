package com.natwest.springwebdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {
    @GetMapping("/displayMsg")
    public String displayMsg(){
        return "this is spring demo ";
    }

    @GetMapping("/displayMsg2")
    public String displayMsg2(){
        return "welcome to spring boot";
    }
}
