package com.example.JobApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    // ************************************************************************

    @RequestMapping({"/","/home"})
    public String home() {
        return "home";
    }

    // ************************************************************************

    @RequestMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    // ************************************************************************

    // controller method for getting all job posts
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";  // Redirects to viewalljobs.jsp
    }

    // ************************************************************************

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJobPost(jobPost);//The controller calls JobService.addJobPost() to store job posts.
        //System.out.println(jobPost);
        return "success"; // Redirects to success.jsp

    }













}