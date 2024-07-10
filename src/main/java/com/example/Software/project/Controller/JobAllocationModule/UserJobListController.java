package com.example.Software.project.Controller.JobAllocationModule;


import com.example.Software.project.Entity.JobAllocationModule.JobListEntity;
import com.example.Software.project.Repo.JobAllocationModule.JobListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/auth")
public class UserJobListController {

    private final JobListRepository jobRepository;
    @Autowired
    public UserJobListController(JobListRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/displayJob")
    public List<JobListEntity> findJob() {
        return jobRepository.findAll();
    }
}
