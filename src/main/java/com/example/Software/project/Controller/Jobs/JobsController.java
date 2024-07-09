package com.example.Software.project.Controller.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software.project.Service.Jobs.JobsService;

import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping
    public Map<String, Long> getCurrentMonthStatus() {
        return jobsService.getCurrentMonthStatus();
    }
}