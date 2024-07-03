package com.example.Software.project.Controller.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Entity.Complain.ReviewedComplain;
//import com.example.Software.project.Entity.DTO.UserComplainDTO;
import com.example.Software.project.Entity.DTO.UserComplainRevDTO;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Repo.Complain.ReviewedComplainRepo;
import com.example.Software.project.Repo.Login.AppUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ReviewedComplainCon {

    private final AppUserRepo appUserRepo;
    private final ReviewedComplainRepo reviewedComplainRepo;

    public ReviewedComplainCon(AppUserRepo appUserRepo, ReviewedComplainRepo reviewedComplainRepo) {
        this.appUserRepo = appUserRepo;
        this.reviewedComplainRepo = reviewedComplainRepo;
    }
//
//    @PostMapping("/addReviewedComplains")
//    public ResponseEntity<?> addReviewedComplains(@RequestBody ReviewedComplain reviewedComplain){
//        try {
//            reviewedComplainRepo.save(reviewedComplain);
//            String message = "Reviewed complaint added"; // Assuming description is a field in the Complain class
//            System.out.println("this is on save or enter complaint");
//            return ResponseEntity.status(HttpStatus.CREATED).body("Reviewed Complaint submitted successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit complaint");
//        }
//    }

    @GetMapping("/getAllReviewedComplains")
    public ResponseEntity<?> getAllReviewedComplains(){
        try {
            List<AppUser> appUsers = appUserRepo.findAll();
            List<ReviewedComplain> reviewedComplains = reviewedComplainRepo.findAll();

            List<UserComplainRevDTO> userComplainRevDTOS = appUsers.stream()
                    .flatMap(user -> reviewedComplains.stream()
                            .filter(reviewedComplain -> reviewedComplain.getEmail().equals(user.getEmail()))
                            .map(reviewedComplain -> new UserComplainRevDTO(user, reviewedComplain))
                    ).collect(Collectors.toList());

            return ResponseEntity.ok().body(userComplainRevDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
        }
    }

}

