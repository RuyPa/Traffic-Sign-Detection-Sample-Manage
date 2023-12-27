package com.example.managesample.controller;

import com.example.managesample.model.User;
import com.example.managesample.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeManagerController {
    private final UserService userService;

    public HomeManagerController(UserService userService){
        this.userService= userService ;
    }

    @PostMapping("/login")
    public String homeManager(@ModelAttribute("user") User user){
        User getUser= userService.getUserByUserName(user.getUsername());
        if(getUser.getPassword().equals(user.getPassword())){
            return "HomeManagerView";
        }
        return "LoginView";
    }

    @GetMapping("/sample/manage")
    public String sampleManage(){
        return "ManageSampleView";
    }

    @GetMapping("")
    public String LoginView(Model model){
        User user= new User();
        model.addAttribute("user", user);
        return "LoginView";
    }
}
