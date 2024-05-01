package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Employee;
import com.example.SpringMongoPoject.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCont {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee emlpoyee){
        employeeRepo.save(emlpoyee);
    }
}
