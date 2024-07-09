package com.example.Software.project.Service.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.JobListEntity;
import com.example.Software.project.Repo.JobAllocationModule.JobListRepository;
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
