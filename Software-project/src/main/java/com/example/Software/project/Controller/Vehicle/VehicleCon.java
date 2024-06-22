package com.example.Software.project.Controller.Vehicle;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.DTO.UnitDTO;
import com.example.Software.project.Entity.DTO.VehicleDTO;
import com.example.Software.project.Entity.Unit.Unit;
import com.example.Software.project.Entity.Vehicle.Vehicle;
import com.example.Software.project.Repo.Vehicle.VehicleRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleCon {

    private final VehicleRepo vehicleRepo;

    public VehicleCon(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }


    @PostMapping("/addVehicle")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        try {
            vehicleRepo.save(vehicle);
            return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle Added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @GetMapping("/getAllVehicles")
    public ResponseEntity<?> getAllVehicles() {
        try {
            List<Vehicle> vehicles = vehicleRepo.findAll();
            return ResponseEntity.ok().body(vehicles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/getVehicle")
    public ResponseEntity<?> getVehicle(@RequestParam String id) {
        try {
            Optional<Vehicle> vehicle = vehicleRepo.findById(id);
            return ResponseEntity.ok().body(vehicle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateVehicle")
    public ResponseEntity<?> updateVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        try {
            Optional<Vehicle> optionalVehicle = vehicleRepo.findById(vehicleDTO.getId());
            if (optionalVehicle.isPresent()) {
                Vehicle vehicle = optionalVehicle.get();
                if(!vehicleRepo.existsByVehicleNumber(vehicleDTO.getVehicleNumber())|| Objects.equals(vehicleDTO.getVehicleNumber(), vehicle.getVehicleNumber())) {
                    vehicle.setVehicleType(vehicleDTO.getVehicleType());
                    vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
                    vehicle.setNoOfPassengers(vehicleDTO.getNoOfPassengers());
                    vehicleRepo.save(vehicle);
                    return ResponseEntity.ok(new MessageResponse("Vehicle updated successfully!"));
                } else {
                    return ResponseEntity.badRequest().body("Vehicle already exists");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle with ID " + vehicleDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating vehicle: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltVehicle")
    public ResponseEntity<MessageResponse> dltVehicle(@RequestParam String id) {
        Optional<Vehicle> optionalVehicle = vehicleRepo.findById(id);
        try {
            if (optionalVehicle.isPresent()) {
                vehicleRepo.delete(optionalVehicle.get());
                return ResponseEntity.ok(new MessageResponse("Vehicle deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Vehicle not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error deleting vehicle: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllVehicle")
    public ResponseEntity<MessageResponse> clearAllVehicle() {
        try {
            vehicleRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all vehicle"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete all vehicles: " + e.getMessage()));
        }
    }


}
