package com.example.jobconnect.controller;


import com.example.jobconnect.entity.Job;
import com.example.jobconnect.entity.User;
import com.example.jobconnect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/add/job")
    public String addJob(Job job) {
        jobService.createJob(job);
        return "redirect:/admin/home";
    }

    @GetMapping("/update/job/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobService.getJobById(id));
        return "UpdateJob";
    }

    @PostMapping("/update/job")
    public String updateJob(@ModelAttribute Job job) {
        jobService.createJob(job);
        return "redirect:/admin/home";
    }



    @GetMapping("/delete/job/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "redirect:/admin/home";
    }


    @GetMapping("/job/{id}")
    public String jobDetail(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id); // Fetch job by ID
        model.addAttribute("job", job);
        return "apply"; // Renders apply.html
    }

    @PostMapping("/apply/{id}")
    public String applyForJob(@PathVariable Long id,
                              @RequestParam String userName,
                              @RequestParam String userEmail,
                              @RequestParam String userResume,
                              RedirectAttributes redirectAttributes) {

        // Save the application data to DB (optional)
        System.out.println("User " + userName + " applied for job ID " + id);

        redirectAttributes.addFlashAttribute("success", "Application submitted successfully!");
        return "redirect:/job";
    }

}
