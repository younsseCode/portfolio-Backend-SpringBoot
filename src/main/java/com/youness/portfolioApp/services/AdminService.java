package com.youness.portfolioApp.services;

import com.youness.portfolioApp.entities.Admin;
import com.youness.portfolioApp.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service

public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
