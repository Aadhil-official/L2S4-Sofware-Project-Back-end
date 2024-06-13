package com.example.dashboard.Vehicles;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehiclesRepository VehiclesRepository;

    public Map<String, Long> getVehicle_type() {
        List<Vehicles> Vehicle = VehiclesRepository.findAll();
        return Vehicle.stream()
                .collect(Collectors.groupingBy(Vehicles::getVehicle_type, Collectors.counting()));
    }
}
