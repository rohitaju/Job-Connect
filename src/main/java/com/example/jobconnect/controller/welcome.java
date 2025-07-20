package com.example.jobconnect.controller;
import java.util.List;

import com.example.jobconnect.entity.Job;
import com.example.jobconnect.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcome {

    @Autowired
    private JobService jobService;

    @GetMapping("/job")
    public String welcome(Model model) {
        List<Job> jobs = jobService.getAllJob();  // Fetch all jobs
        model.addAttribute("jobList", jobs);

        return "job.html";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "AboutUs";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "ContactUs";
    }

    @GetMapping("/home")
    public String home() {
        return "welcome";
    }




}
