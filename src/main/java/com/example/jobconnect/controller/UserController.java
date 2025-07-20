package com.example.jobconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.jobconnect.entity.User;
import com.example.jobconnect.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/update/user/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));

        return "UpdateUser";
    }

    @PostMapping("/add/user")
    public String addUser(User user) {
        userService.createUser(user);

        return "redirect:/admin/home";
    }

    @PostMapping("/update/user")
    public String updateUser(User user) {
        userService.createUser(user);

        return "redirect:/admin/home";
    }

    @GetMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return "redirect:/admin/home";
    }

}
