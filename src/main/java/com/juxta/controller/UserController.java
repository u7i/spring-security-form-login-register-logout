package com.juxta.controller;

import com.juxta.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final AdminService adminService;

    @Autowired
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/user")
    public String registrationForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        return "/user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        adminService.onlyAdmin();
        return "/admin";
    }
}
