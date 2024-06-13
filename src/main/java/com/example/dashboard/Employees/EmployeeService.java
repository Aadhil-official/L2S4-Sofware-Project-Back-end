package com.example.dashboard.Employees;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Map<String, Long> getDesignationCounts() {
        List<Employees> employees = employeesRepository.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(Employees::getJOB_ID, Collectors.counting()));
    }
}
