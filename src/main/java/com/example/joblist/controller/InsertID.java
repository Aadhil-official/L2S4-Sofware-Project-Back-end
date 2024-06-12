package com.example.joblist.controller;

import com.example.joblist.model.Job;
import com.example.joblist.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*",maxAge= 3600)
@RestController
@RequestMapping("api/auth")

public class InsertID {

    private final JobRepository jobRepository;

    public InsertID(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("findJob")
    public List<Job> getJobs() {
        return jobRepository.findAll();

    }

    @PostMapping("/addJob")
    public String saveJob(@RequestBody Job job){
      //  Optional<Job> job1=jobRepository.findByItem(job.getItem());
//        if(jobRepository.existsById(job.getId()));
        jobRepository.save(job);
        return "Saved Successfully";


    }
}
