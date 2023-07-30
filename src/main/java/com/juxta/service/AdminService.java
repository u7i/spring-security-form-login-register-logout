package com.juxta.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public void onlyAdmin() {
        System.out.println("I`m admin!");
    }
}