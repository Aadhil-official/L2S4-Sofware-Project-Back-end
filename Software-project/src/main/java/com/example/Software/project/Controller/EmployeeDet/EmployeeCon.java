package com.example.Software.project.Controller.EmployeeDet;

import com.example.Software.project.Entity.DTO.AppUserDTO;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Repo.Login.AppUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EmployeeCon {

    final AppUserRepo appUserRepo;

    public EmployeeCon(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @PostMapping("/findappusers")
    public ResponseEntity<?> findAllUsers() {
        try {
            List<AppUser> appUsers = appUserRepo.findAll();
            List<AppUserDTO> appUserDtos = appUsers.stream()
                    .map(user -> new AppUserDTO(user.getUsername(), user.getAddress(), user.getTel(), user.getRoles()))
                    .collect(Collectors.toList());
            System.out.println(appUserDtos);
            return ResponseEntity.ok().body(appUserDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
        }
    }
}
