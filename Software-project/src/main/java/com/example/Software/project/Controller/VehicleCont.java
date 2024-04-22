package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Vehicle;
import com.example.Software.project.Repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehiclecont")
public class VehicleCont {
    @Autowired
    VehicleRepo vehicleRepo;
    @PostMapping("/addVehicle")
    public void addVehicle(@RequestBody Vehicle vehicle)
    {
        vehicleRepo.save(vehicle);
    }
}
