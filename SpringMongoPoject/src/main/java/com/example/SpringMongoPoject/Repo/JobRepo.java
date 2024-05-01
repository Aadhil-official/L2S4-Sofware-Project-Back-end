package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<Job,Integer> {
}
