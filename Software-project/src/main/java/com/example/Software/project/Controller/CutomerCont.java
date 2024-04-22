package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Customer;
import com.example.Software.project.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cutomercount")
public class CutomerCont {
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
    }
}
