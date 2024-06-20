package com.example.Software.project.Controller.UserGroup;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.DTO.UserGroupDTO;
import com.example.Software.project.Entity.UserGroup.UserGroup;
import com.example.Software.project.Repo.UserGroup.UserGroupRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserGroupCon {

    private final UserGroupRepo userGroupRepo;

    public UserGroupCon(UserGroupRepo userGroupRepo) {
        this.userGroupRepo = userGroupRepo;
    }

    @PostMapping("/addUserGroup")
    public ResponseEntity<String> addUserGroup(@RequestBody UserGroup userGroup) {
        try {
            userGroupRepo.save(userGroup);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Group Added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @GetMapping("/getAllUserGroups")
    public ResponseEntity<?> getAllUserGroups() {
        try {
            List<UserGroup> userGroups = userGroupRepo.findAll();
            return ResponseEntity.ok().body(userGroups);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/getUserGroup")
    public ResponseEntity<?> getUserGroup(@RequestParam String id) {
        try {
            Optional<UserGroup> userGroup = userGroupRepo.findById(id);
            return ResponseEntity.ok().body(userGroup);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateUserGroup")
    public ResponseEntity<?> updateUserGroup(@Valid @RequestBody UserGroupDTO userGroupDTO) {
        try {
            Optional<UserGroup> optionalUserGroup = userGroupRepo.findById(userGroupDTO.getId());
            if (optionalUserGroup.isPresent()) {
                UserGroup userGroup = optionalUserGroup.get();
                userGroup.setGroupName(userGroupDTO.getGroupName());
                userGroup.setGroupDescription(userGroupDTO.getGroupDescription());
                userGroup.setRelevantPrivileges(userGroupDTO.getRelevantPrivileges());
                userGroup.setAllocatedJobs(userGroupDTO.getAllocatedJobs());
                userGroupRepo.save(userGroup);
                return ResponseEntity.ok(new MessageResponse("User Group updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Group with ID " + userGroupDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user group: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltUserGroup")
    public ResponseEntity<MessageResponse> dltUserGroup(@RequestParam String id) {
        Optional<UserGroup> optionalUserGroup = userGroupRepo.findById(id);
        try {
            if (optionalUserGroup.isPresent()) {
                userGroupRepo.delete(optionalUserGroup.get());
                return ResponseEntity.ok(new MessageResponse("User group deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("User group not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error deleting user group: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllUserGroups")
    public ResponseEntity<MessageResponse> clearAllUserGroups() {
        try {
            userGroupRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all user group"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete all user groups: " + e.getMessage()));
        }
    }

}
