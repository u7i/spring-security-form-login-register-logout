package com.juxta.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/403")
//    public String accessDeniedPage() {
//        return "/error/403";
//    }
}