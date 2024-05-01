package com.example.Software.project.Controller.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Repo.Complain.ComplainRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ComplainCont {
    private final ComplainRepo complainRepo;

    public ComplainCont(ComplainRepo complainRepo) {
        this.complainRepo = complainRepo;
    }

    @PostMapping("/complaints")
    public ResponseEntity<String> submitComplaint(@RequestBody Complain complain) {
        try {
            complainRepo.save(complain);
            return ResponseEntity.status(HttpStatus.CREATED).body("Complaint submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit complaint");
        }
    }
}
