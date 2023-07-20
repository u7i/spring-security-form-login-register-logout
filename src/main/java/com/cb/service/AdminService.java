package com.cb.service;

import com.cb.util.Roles;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize(value = Roles.ADMIN)
    public void onlyAdmin() {
        System.out.println("I`m admin!");
    }
}