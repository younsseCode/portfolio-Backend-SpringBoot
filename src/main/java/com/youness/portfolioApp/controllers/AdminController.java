package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.entities.Admin;
import com.youness.portfolioApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public List<Admin> getAllAdmin(){
        return adminService.findAllAdmin();
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @GetMapping("/index")
    public String sendMessage(){
        return "hello index";
    }


    @GetMapping("/hi")
    public String SayHello(){
        return "HELLO !!";
    }

}
