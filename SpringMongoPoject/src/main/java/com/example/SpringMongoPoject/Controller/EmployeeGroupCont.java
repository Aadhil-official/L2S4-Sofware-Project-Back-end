package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.EmployeeGroup;
import com.example.SpringMongoPoject.Repo.EmployeeGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeGroupCont {
    @Autowired
    EmployeeGroupRepo employeeGroupRepo;
    @PostMapping("/addEmpGroup")
    public void addEmpGroup(@RequestBody EmployeeGroup employeeGroup)
    {
        employeeGroupRepo.save(employeeGroup);
    }
}
