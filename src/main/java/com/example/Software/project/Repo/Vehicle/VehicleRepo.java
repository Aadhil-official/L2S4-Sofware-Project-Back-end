package com.example.Software.project.Repo.Vehicle;

import com.example.Software.project.Entity.Vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepo extends MongoRepository<Vehicle,String> {
    Boolean existsByVehicleNumber(String vehicleNumber);
}
