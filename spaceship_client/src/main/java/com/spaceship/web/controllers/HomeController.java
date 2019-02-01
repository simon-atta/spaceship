package com.spaceship.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", this.message);
        return "welcome";
    }


    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", this.message);
        return "welcome";
    }
}
