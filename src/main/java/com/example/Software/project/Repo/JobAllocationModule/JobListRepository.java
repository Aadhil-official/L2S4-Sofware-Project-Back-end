package com.example.Software.project.Repo.JobAllocationModule;

import com.example.project_backend.Entity.JobListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListRepository extends MongoRepository<JobListEntity, String> {
}
