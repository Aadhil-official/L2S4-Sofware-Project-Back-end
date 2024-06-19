package com.example.Software.project.Controller.Unit;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.DTO.UnitDTO;
import com.example.Software.project.Entity.Unit.Unit;
import com.example.Software.project.Repo.Item.ItemRepo;
import com.example.Software.project.Repo.Unit.UnitRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UnitCon {

    private final UnitRepo unitRepo;

    public UnitCon(UnitRepo unitRepo) {
        this.unitRepo = unitRepo;
    }


    @PostMapping("/addUnit")
    public ResponseEntity<String> addUnit(@RequestBody Unit unit) {
        try {
            unitRepo.save(unit);
            return ResponseEntity.status(HttpStatus.CREATED).body("Unit Added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @GetMapping("/getAllUnits")
    public ResponseEntity<?> getAllUnits() {
        try {
            List<Unit> units = unitRepo.findAll();
            return ResponseEntity.ok().body(units);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/getUnit")
    public ResponseEntity<?> getUnit(@RequestParam String id) {
        try {
            Optional<Unit> unit = unitRepo.findById(id);
            return ResponseEntity.ok().body(unit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateUnit")
    public ResponseEntity<?> updateUnit(@Valid @RequestBody UnitDTO unitDTO) {
        try {
            Optional<Unit> optionalUnit = unitRepo.findById(unitDTO.getId());
            if (optionalUnit.isPresent()) {
                Unit unit = optionalUnit.get();
                unit.setIndoorSerial(unitDTO.getIndoorSerial());
                unit.setOutdoorSerial(unitDTO.getOutdoorSerial());
                unit.setModelName(unitDTO.getModelName());
                unit.setCommissionedDate(unitDTO.getCommissionedDate());
                unit.setOwner(unitDTO.getOwner());
                unit.setWarrantyPeriod(unitDTO.getWarrantyPeriod());
                unit.setUnitPrice(unitDTO.getUnitPrice());
                unitRepo.save(unit);
                return ResponseEntity.ok(new MessageResponse("Unit updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unit with ID " + unitDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating unit: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltUnit")
    public ResponseEntity<MessageResponse> dltUnit(@RequestParam String id) {
        Optional<Unit> optionalUnit = unitRepo.findById(id);
        try {
            if (optionalUnit.isPresent()) {
                unitRepo.delete(optionalUnit.get());
                return ResponseEntity.ok(new MessageResponse("Unit deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Unit not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error deleting unit: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllUnits")
    public ResponseEntity<MessageResponse> clearAllUnits() {
        try {
            unitRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all units"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete all units: " + e.getMessage()));
        }
    }

}



