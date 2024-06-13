package com.example.Software.project.Controller.EmployeeDet;

import com.example.Software.project.Entity.DTO.AppUserDTO;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Entity.Login.Role;
import com.example.Software.project.Repo.Login.AppUserRepo;
import com.example.Software.project.Repo.Login.RoleRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EmployeeCon {

    final AppUserRepo appUserRepo;

    final RoleRepo roleRepo;

    public EmployeeCon(AppUserRepo appUserRepo, RoleRepo roleRepo) {
        this.appUserRepo = appUserRepo;
        this.roleRepo = roleRepo;
    }

    @PostMapping("/findappusers")
    public ResponseEntity<?> findAllUsers() {
        try {
            List<AppUser> appUsers = appUserRepo.findAll();
            List<AppUserDTO> appUserDtos = appUsers.stream()
                    .map(user -> new AppUserDTO(user.getId(),user.getUsername(), user.getEmail(), user.getTel(),user.getAddress(),user.getUsergroup(), user.getRoles()))
                    .collect(Collectors.toList());
//            System.out.println(appUserDtos);
            return ResponseEntity.ok().body(appUserDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
        }
    }


//    @PutMapping("/updateappuser/{userId}")
//    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody AppUserDTO updateAppUserDTO) {
//        try {
//            AppUser user = appUserRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//
//            // Update user information
//            user.setUsername(updateAppUserDTO.getUsername());
//            user.setEmail(updateAppUserDTO.getEmail());
//            user.setAddress(updateAppUserDTO.getAddress());
//            user.setUsergroup(updateAppUserDTO.getUsergroup());
//            user.setTel(updateAppUserDTO.getTel());
//
//            // Update roles
//            Set<Role> roles = new HashSet<>();
//            for (Role roleName : updateAppUserDTO.getRoles()) {
//                Role role = roleRepo.findByName(roleName.getName())
//                        .orElseThrow(() -> new RuntimeException("Role not found"));
//                roles.add(role);
//            }
//            user.setRoles(roles);
//
//            appUserRepo.save(user);
//
//            return ResponseEntity.ok().body("User updated successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/findappuser")
//    public ResponseEntity<?> findUserById(@RequestParam String username) {
//        try {
//            Optional<AppUser> appUsers = appUserRepo.findByUsername(username);
//            List<AppUserDTO> appUserDtos = appUsers.stream()
//                    .map(user -> new AppUserDTO(user.getId(),user.getUsername(), user.getAddress(), user.getTel(),user.getUsergroup(),user.getEmail(), user.getRoles()))
//                    .collect(Collectors.toList());
////            System.out.println(appUserDtos);
//            return ResponseEntity.ok().body(appUserDtos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
//        }
//    }

}
