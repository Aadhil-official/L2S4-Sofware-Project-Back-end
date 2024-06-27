package com.example.backendArctic.Repo;

import com.example.backendArctic.Entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<Job,String> {

}
