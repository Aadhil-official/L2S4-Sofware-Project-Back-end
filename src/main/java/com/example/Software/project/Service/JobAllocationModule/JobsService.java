package com.example.Software.project.Service.JobAllocationModule;

import com.example.project_backend.Repository.JobDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    private final JobDetailsRepo jobsRepository;

    @Autowired
    public JobsService(JobDetailsRepo jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    // Save or update a job
    public JobDetailsRepo saveOrUpdateJob(JobDetailsRepo job) {
        return jobsRepository.save(job);
    }

    // Get all jobs
    public List<JobDetailsRepo> getAllJobs() {
        return jobsRepository.findAll();
    }

    // Get job by ID
    public Optional<JobDetailsRepo> getJobById(String id) {
        return jobsRepository.findById(id);
    }

    // Delete job by ID
    public void deleteJobById(String id) {
        jobsRepository.deleteById(id);
    }
}
