package com.samson.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = {"/", "index.asp", "index.html", "index.jsp"})
    public String getHomePage(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("greeting", "Welcome to Samson's Shop");
        model.addAttribute("tagline", "The one and only shop for your needs");

        redirectAttributes.addFlashAttribute("greeting", "WWelcome to Samson's Shop");
        redirectAttributes.addFlashAttribute("tagline", "TThe one and only shop for your needs");
        return "redirect:/index/greeting";
    }

    @RequestMapping(value = "/index/greeting")
    public String greeting(){
        return "index";
    }
}
