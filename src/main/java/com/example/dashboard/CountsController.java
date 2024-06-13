package com.example.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counts")
public class CountsController {

    @Autowired
    private CountsService countsService;

    @GetMapping
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("units", countsService.getUnitsCount());
        counts.put("jobs", countsService.getJobsCount());
        counts.put("items", countsService.getItemsCount());
        counts.put("customers", countsService.getCustomersCount());
        counts.put("employees", countsService.getEmployeesCount());
        counts.put("vehicles", countsService.getVehiclesCount());
        return ResponseEntity.ok(counts);
    }
}

