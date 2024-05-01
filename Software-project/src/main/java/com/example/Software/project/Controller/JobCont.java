package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Job;
import com.example.Software.project.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobcont")
public class JobCont {
    @Autowired
    JobRepo jobRepo;
    @PostMapping("/addJob")
    public void addJob(@RequestBody Job job)
    {
        jobRepo.save(job);
    }
}
