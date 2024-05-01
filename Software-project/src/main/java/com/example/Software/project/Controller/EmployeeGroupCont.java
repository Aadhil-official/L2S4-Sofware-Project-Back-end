package com.example.Software.project.Controller;

import com.example.Software.project.Entity.EmployeeGroup;
import com.example.Software.project.Repo.EmployeeGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employeegroupcont")
public class EmployeeGroupCont {
    @Autowired
    EmployeeGroupRepo employeeGroupRepo;
    @PostMapping("/addEmpGroup")
    public void addEmpGroup(@RequestBody EmployeeGroup employeeGroup)
    {

        employeeGroupRepo.save(employeeGroup);
    }
}
