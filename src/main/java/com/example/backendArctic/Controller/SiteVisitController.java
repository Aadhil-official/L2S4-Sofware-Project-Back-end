package com.example.backendArctic.Controller;

import com.example.backendArctic.Entity.Dto.SiteVisitDto;
import com.example.backendArctic.Entity.SiteVisit;
import com.example.backendArctic.Repo.GatePassRepo;
import com.example.backendArctic.Repo.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/siteVisit")
public class SiteVisitController {

    @Autowired
    private SiteVisitRepo siteVisitRepo;

    private GatePassRepo gatePassRepo;

//    private final AppUserRepo appUserRepo;
//
//    private final UserGroupRepo userGroupRepo;

    @PostMapping("/addSiteVisit")
    public ResponseEntity<?> addSiteVisit(@RequestBody SiteVisit siteVisit) {
        try {
//            GatePass gatePass =new GatePass();
//            gatePass.setId(siteVisit.getVisitId());
//            gatePass.setVehicleNumber(siteVisit.getVehicleNumber());
//            gatePass.setGroupName(siteVisit.getGroupName());


//            List<AppUser> appUsers = appUserRepo.findAll();
//            UserGroup userGroups = userGroupRepo.findByGroupName(siteVisit.getGroupName());
//
//
//            List<UserGroupDTO> groupMembers = appUsers.stream()
//                    .flatMap(members -> userGroups.stream()
//                            .filter(userGroup -> userGroup.getGroupName().equals(userGroup.getUsergroup()))
//                            .map(userGroup -> new UserGroupDTO(members,userGroup))
//                    ).collect(Collectors.toList());

            //gatePass.setGpMembers(groupMembers);



            siteVisitRepo.save(siteVisit);
//            return ResponseEntity.ok().body(siteVisit.getVisitId());
            return ResponseEntity.ok().body(Collections.singletonMap("visitId", siteVisit.getVisitId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

//    @GetMapping("/getGatePass")
//    public ResponseEntity<?> getGatePass(@RequestParam String id){
//        try {
//            Optional<GatePass> optionalGatePass = gatePassRepo.findById(id);
//            if (optionalGatePass.isPresent()){
//                return ResponseEntity.ok().body(optionalGatePass);
//
//            }else {
//                return ResponseEntity.badRequest().body("Gate pass not found");
//            }
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }


    @PutMapping("/updateSiteVisit")
    public ResponseEntity<?> updateSiteVisit(@RequestBody SiteVisitDto siteVisitDto) {
        try {
            Optional<SiteVisit> optionalSiteVisit = siteVisitRepo.findById(siteVisitDto.getVisitId());
            if (optionalSiteVisit.isPresent()) {

                SiteVisit siteVisit = optionalSiteVisit.get();

                    siteVisit.setVehicleNumber(siteVisitDto.getVehicleNumber());
                    siteVisit.setLocation(siteVisitDto.getLocation());
                    siteVisit.setCustomerName(siteVisitDto.getCustomerName());
                    siteVisit.setScheduleDate(siteVisitDto.getScheduleDate());
                    siteVisit.setSelectedTime(siteVisitDto.getSelectedTime());
                    siteVisit.setNumberOfEmployees(siteVisitDto.getNumberOfEmployees());
                    siteVisit.setEmail(siteVisitDto.getEmail());
                    siteVisitRepo.save(siteVisit);
                    return ResponseEntity.ok("Site Visit updated successfully!");

             } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + siteVisitDto.getVisitId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteSiteVisit")
    public void deleteSiteVisit(@RequestParam String id) {
        siteVisitRepo.deleteById(id);
    }



    @GetMapping("/getSiteVisit")
    public ResponseEntity<List<SiteVisit>> getSiteVisit() {
        try {
            List<SiteVisit> siteVisits = siteVisitRepo.findAll();
            return ResponseEntity.ok(siteVisits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getSiteVisitTwo")
    public ResponseEntity<?> getSiteVisitTwo(@RequestParam String id) {
        try {
            Optional<SiteVisit> siteVisit = siteVisitRepo.findById(id);
            return ResponseEntity.ok().body(siteVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
//    @GetMapping("/getGatePass")
//    public ResponseEntity<?> geyGatePass(@RequestParam String id) {
//        Optional<GatePass> gatePass = gatePassRepo.findById(id);
//        return ResponseEntity.ok().body(gatePass);
//    }






}
