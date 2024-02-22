package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Vehicle;
import com.example.SpringMongoPoject.Repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleCont {
    @Autowired
    VehicleRepo vehicleRepo;
    @PostMapping("/addVehicle")
    public void addVehicle(@RequestBody Vehicle vehicle)
    {
        vehicleRepo.save(vehicle);
    }
}
