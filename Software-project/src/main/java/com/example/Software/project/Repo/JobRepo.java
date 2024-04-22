package com.example.Software.project.Repo;

import com.example.Software.project.Entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<Job,Integer> {
}
