package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Customer;
import com.example.SpringMongoPoject.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CutomerCont {
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
    }
}
