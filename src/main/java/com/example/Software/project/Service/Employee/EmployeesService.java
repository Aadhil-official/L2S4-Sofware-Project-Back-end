package com.example.Software.project.Service.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Software.project.Entity.Employee.Employees;
import com.example.Software.project.Repo.Employee.EmployeesRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Map<String, Long> getEmployeesCounts() {
        List<Employees> employees = employeesRepository.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(Employees::getJOB_ID, Collectors.counting()));
    }
}