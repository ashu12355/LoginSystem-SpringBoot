package com.ashu.demo.controller;

import com.ashu.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Render the login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (loginService.validateUser(username, password)) {
            return "redirect:/success";  // Redirect to success page
        } else {
            model.addAttribute("errorMessage", "Invalid credentials!");
            return "login";  // Return to login page with error message
        }
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";  // Render the success.html page
    }
}
