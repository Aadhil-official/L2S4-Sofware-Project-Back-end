package com.example.Software.project.Repo.Jobs;

import com.example.Software.project.Entity.Jobs.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepo extends MongoRepository<Job, String> {
}
