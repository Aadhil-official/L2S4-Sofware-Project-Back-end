package com.example.Software.project.Service.JobAllocationModule;

import com.example.project_backend.Entity.JobListEntity;
import com.example.project_backend.Repository.JobListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobListService {

    private final JobListRepository jobRepository;

    @Autowired
    public JobListService(JobListRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobListEntity> getAllJobs() {
        return jobRepository.findAll();
    }

    public void saveJob(JobListEntity job) {
        jobRepository.save(job);
    }
}
