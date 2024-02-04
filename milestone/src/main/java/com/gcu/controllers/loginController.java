package com.gcu.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import com.gcu.models.LoginModel;
import com.gcu.business.SecurityServiceInterface;

@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    SecurityServiceInterface securityService;
    
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login"; 
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return "login"; 
        }
        
        if (securityService.isAuthenticated(loginModel)){
            model.addAttribute("model", loginModel);
            return "loginSuccess";
        }
        else{
            return "login";
        }
        
    }
}
