package com.example.Software.project.Repo;

import com.example.Software.project.Entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepo extends MongoRepository<Vehicle,Integer> {
}
