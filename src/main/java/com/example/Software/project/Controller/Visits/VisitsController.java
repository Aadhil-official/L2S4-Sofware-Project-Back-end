package com.example.Software.project.Controller.Visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software.project.Service.Visits.VisitsService;

import java.util.Map;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class VisitsController {

    private final VisitsService visitsService;

    public VisitsController(VisitsService visitsService) {
        this.visitsService = visitsService;
    }


    @GetMapping("/getVisits")
    public Map<String, Long> getCurrentMonthStatus() {
        return visitsService.getCurrentMonthStatus();
    }
}
