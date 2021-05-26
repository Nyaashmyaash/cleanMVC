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
    public String goodbyePage() {
        return "entrance/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int a,
                                 @RequestParam("b") int b,
                                 @RequestParam("action") String action,
                                 Model model) {
        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = (a / b);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }

        model.addAttribute("message", "result = " + result);

        return "entrance/calculator";
    }
}
