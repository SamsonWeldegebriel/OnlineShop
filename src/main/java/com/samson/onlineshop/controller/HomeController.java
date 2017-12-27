package com.samson.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = {"/", "index.asp", "index.html", "index.jsp"})
    public String getHomePage(Model model){
        model.addAttribute("greeting", "Welcome to Samson's Shop");
        model.addAttribute("taglin", "The one and only shop for your needs");
        return "index";
    }
}
