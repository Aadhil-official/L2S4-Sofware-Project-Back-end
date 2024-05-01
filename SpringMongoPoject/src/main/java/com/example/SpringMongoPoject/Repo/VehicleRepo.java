package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepo extends MongoRepository<Vehicle,Integer> {
}
