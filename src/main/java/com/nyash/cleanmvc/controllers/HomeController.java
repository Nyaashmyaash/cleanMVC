package com.nyash.cleanmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model) {

//        System.out.println("Hello " + name + "  " + surname);
        model.addAttribute("message", "Hello " + name + "  " + surname);

        return "entrance/home";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "entrance/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(HttpServletRequest request, Model model){
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        


        return "entrance/calculator";
    }
}
