package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class homeController {
    
    @GetMapping("/")
    public String display() {
        return "index"; 
    }
}
