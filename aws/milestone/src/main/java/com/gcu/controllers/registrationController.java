package com.gcu.controllers;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.models.LoginModel;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class registrationController {
    @Autowired
    SecurityServiceInterface securityService;


    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("loginModel", new LoginModel());
        return "registration";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Registration Form"); 
            return "registration";
        }
        
        if (securityService.isTaken(loginModel)){
            model.addAttribute("model", loginModel);
            return "registration";
        }
        else{
            
            return "registerSuccess";
        }
        
    }
}
