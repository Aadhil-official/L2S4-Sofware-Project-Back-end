//package com.example.backendArctic.Controller;
//
//import com.example.backendArctic.Service.SiteVisitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "*" ,maxAge =3600)
//@RestController
//@RequestMapping("/api/v1/siteVisitStEd") // Updated base path to avoid conflict
//public class SiteVisitStEd {
//
//    @Autowired
//    private SiteVisitService siteVisitService;
//
//    @PostMapping("/start/{visitId}")
//    public ResponseEntity<String> startSiteVisit(@PathVariable String visitId) {
//        try {
//            siteVisitService.startSiteVisit(visitId);
//            return ResponseEntity.ok("Site Visit started successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to start site visit: " + e.getMessage());
//        }
//    }
//    @PostMapping("/cancel/{visitId}")
//    public ResponseEntity<String> cancelSiteVisit(@PathVariable String visitId) {
//        try {
//            siteVisitService.cancelSiteVisit(visitId); // Implement this method in your service layer
//            return ResponseEntity.ok("Site Visit canceled successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to cancel site visit");
//        }
//    }
//
//    @PostMapping("/end/{id}")
//    public ResponseEntity<String> endSiteVisit(@PathVariable String id) {
//        try {
//            siteVisitService.endSiteVisit(id); // Implement this method in your service layer
//            return ResponseEntity.ok("Site Visit ended successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to end site visit");
//        }
//    }
//    @PostMapping("/saveClickDate")
//    public ResponseEntity<String> saveClickDate(@RequestParam String visitId) {
//        try {
//            siteVisitService.saveClickDate(visitId); // Call the service method to save click date
//            return ResponseEntity.ok("Click date saved successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save click date: " + e.getMessage());
//        }
//    }
//
//}
package com.example.Software.project.Controller.ServiceAgreement;

import com.example.Software.project.Service.SiteVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/siteVisitStEd")
public class SiteVisitStEd {

    private final SiteVisitService siteVisitService;

    public SiteVisitStEd(SiteVisitService siteVisitService) {
        this.siteVisitService = siteVisitService;
    }

    @PostMapping("/start/{visitId}")
    public ResponseEntity<String> startSiteVisit(@PathVariable String visitId) {
        try {
            if (siteVisitService.isVisitStarted(visitId)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Site visit already started");
            }
            siteVisitService.startSiteVisit(visitId);
            return ResponseEntity.ok("Site Visit started successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to start site visit: " + e.getMessage());
        }
    }

    @PostMapping("/cancel/{visitId}")
    public ResponseEntity<String> cancelSiteVisit(@PathVariable String visitId) {
        try {
            if (siteVisitService.isVisitCanceled(visitId)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Site visit already canceled");
            }
            siteVisitService.cancelSiteVisit(visitId);
            return ResponseEntity.ok("Site Visit canceled successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to cancel site visit");
        }
    }

    @PostMapping("/end/{visitId}")
    public ResponseEntity<String> endSiteVisit(@PathVariable String visitId) {
        try {
            if (siteVisitService.isVisitEnded(visitId)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Site visit already ended");
            }
            siteVisitService.endSiteVisit(visitId);
            return ResponseEntity.ok("Site Visit ended successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to end site visit");
        }
    }
}
