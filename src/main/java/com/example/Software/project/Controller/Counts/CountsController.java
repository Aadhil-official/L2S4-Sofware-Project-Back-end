package com.example.Software.project.Controller.Counts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software.project.Service.Counts.CountsService;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class CountsController {

    private final CountsService countsService;

    public CountsController(CountsService countsService) {
        this.countsService = countsService;
    }

    @GetMapping("/Counts")
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("units", countsService.getUnitsCount());
        counts.put("jobs", countsService.getCurrentMonthJobsCount());
        counts.put("items", countsService.getItemsCount());
        counts.put("customers", countsService.getCustomersCount());
        counts.put("employees", countsService.getEmployeesCount());
        counts.put("vehicles", countsService.getVehiclesCount());
        counts.put("visits", countsService.getCurrentMonthVisitsCount());
        return ResponseEntity.ok(counts);
    }

    
}
