package com.example.Software.project.Repo.JobsRepo;

import com.example.Software.project.Entity.JobsEntity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepo extends MongoRepository<Job,String> {
    Boolean existsByVehicleNumber(String vehicleNumber);
    Boolean existsByDate(String date);
}
