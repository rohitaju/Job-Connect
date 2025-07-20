package com.example.jobconnect.controller;

import java.awt.JobAttributes;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.jobconnect.entity.Admin;
import com.example.jobconnect.entity.Job;
import com.example.jobconnect.entity.User;
import com.example.jobconnect.service.AdminService;
import com.example.jobconnect.service.HomeService;
import com.example.jobconnect.service.JobService;
import com.example.jobconnect.service.UserService;

@Controller

public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private HomeService homeService;

	@Autowired
	private JobService jobService;


	@GetMapping("/admin/home")
	public String adminHomePage(Model model) {
		model.addAttribute("adminList", adminService.getAllAdmin());
		model.addAttribute("userList", userService.getAllUser());
		model.addAttribute("jobList", jobService.getAllJob());
		model.addAttribute("productList", homeService.getAllHome());
		model.addAttribute("job", new Job());


		return "AdminHomePage";
	}

	@PostMapping("/add/admin")
	public String createAdmin(Admin admin) {
		adminService.createUser(admin);

		return "redirect:/admin/home";
	}

	@GetMapping("/update/admin/{id}")
	public String update(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("admin", adminService.getAdminById(id));
		return "UpdateAdmin";
	}

	@PostMapping("/update/admin")
	public String updateAdmin(Admin admin) {
		adminService.updateAdmin(admin);

		return "redirect:/admin/home";
	}

	@GetMapping("/delete/admin/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);

		return "redirect:/admin/home";
	}







}