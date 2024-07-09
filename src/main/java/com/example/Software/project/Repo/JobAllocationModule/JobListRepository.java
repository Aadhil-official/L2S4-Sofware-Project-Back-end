package com.example.Software.project.Repo.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.JobListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListRepository extends MongoRepository<JobListEntity, String> {
}
