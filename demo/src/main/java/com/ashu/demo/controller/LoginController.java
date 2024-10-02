package com.ashu.demo.controller;

import com.ashu.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller  //Marks this class as a Spring MVC controller.
public class LoginController {

    @Autowired //This annotation is used to automatically inject the LoginService dependency.
    private LoginService loginService;

    @GetMapping("/login") //Handles GET requests for the login form.
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login") //Handles POST requests for login. It validates user credentials using the LoginService.

    public String login(@RequestParam String username, @RequestParam String password, Model model) 
    //@RequestParam to get the username and password from the request.
    {
        if (loginService.validateUser(username, password)) {
            return "redirect:/success";
        } else {
            model.addAttribute("errorMessage", "Invalid credentials!"); // Adds error message to model
            return "login"; // Returns to login page if credentials are invalid
        }
        }
    

    @GetMapping("/success") //Displays a success page after successful login
    public String showSuccessPage() {
        return "success"; // Returns the success.html view
    }
}
