package com.example.Software.project.Controller.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.ServiceAgreement;
import com.example.Software.project.Repo.ServiceAgreement.ServiceAgreementRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ServiceAgreementCon {

    private final ServiceAgreementRepo serviceAgreementRepo;

    public ServiceAgreementCon(ServiceAgreementRepo serviceAgreementRepo) {
        this.serviceAgreementRepo = serviceAgreementRepo;
    }

    @PostMapping("/addService")
    public ResponseEntity<String> addService(@RequestBody ServiceAgreement serviceAgreement) {
        try {
            serviceAgreementRepo.save(serviceAgreement);
            return ResponseEntity.status(HttpStatus.CREATED).body("ServiceAdded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @PostMapping("/getAllServices")
    public ResponseEntity<?> findServices() {
        try {
            List<ServiceAgreement> serviceAgreements = serviceAgreementRepo.findAll();
            return ResponseEntity.ok().body(serviceAgreements);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}




