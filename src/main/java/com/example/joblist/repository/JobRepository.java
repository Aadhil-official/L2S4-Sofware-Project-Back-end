package com.example.joblist.repository;

import com.example.joblist.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String>
{
//    Boolean existsById(String id);
//    Optional<Job> findByItem(String item);
}
