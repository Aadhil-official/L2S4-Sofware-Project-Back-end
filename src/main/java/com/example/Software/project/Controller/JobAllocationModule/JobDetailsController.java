package com.example.Software.project.Controller.JobAllocationModule;

import com.example.Software.project.Repo.JobAllocationModule.JobDetailsRepo;
import com.example.Software.project.Service.JobAllocationModule.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth/jobs")
public class JobDetailsController {

    private final JobsService jobsService;

    @Autowired
    public JobDetailsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    // Endpoint to create or update a job
    @PostMapping("/post")
    public ResponseEntity<JobDetailsRepo> createOrUpdateJob(@RequestBody JobDetailsRepo job) {
        JobDetailsRepo savedJob = jobsService.saveOrUpdateJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    // Endpoint to get all jobs
    @GetMapping("/get")
    public ResponseEntity<List<JobDetailsRepo>> getAllJobs() {
        List<JobDetailsRepo> jobs = jobsService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    // Endpoint to get job by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobDetailsRepo> getJobById(@PathVariable String id) {
        Optional<JobDetailsRepo> job = jobsService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to delete job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable String id) {
        jobsService.deleteJobById(id);
        return ResponseEntity.noContent().build();
    }
}
