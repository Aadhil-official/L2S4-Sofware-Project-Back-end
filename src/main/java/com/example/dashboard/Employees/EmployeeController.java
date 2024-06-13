package com.example.dashboard.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/designationCounts")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Map<String, Long> getDesignationCounts() {
        return employeeService.getDesignationCounts();
    }
}
