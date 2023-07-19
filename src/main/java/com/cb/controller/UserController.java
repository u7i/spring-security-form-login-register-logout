package com.cb.controller;

import com.cb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final AdminService adminService;

    @Autowired
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/user")
    public String registrationForm() {
        return "/user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        adminService.onlyAdmin();
        return "/admin";
    }
}
