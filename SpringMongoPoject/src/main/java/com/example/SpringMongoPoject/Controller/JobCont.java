package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Job;
import com.example.SpringMongoPoject.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobCont {
    @Autowired
    JobRepo jobRepo;
    @PostMapping("/addJob")
    public void addJob(@RequestBody Job job)
    {
        jobRepo.save(job);
    }
}
