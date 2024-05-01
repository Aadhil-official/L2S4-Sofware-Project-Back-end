package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Employee;
import com.example.Software.project.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employeecont")
public class EmployeeCont {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee emlpoyee){
        employeeRepo.save(emlpoyee);
    }
}
