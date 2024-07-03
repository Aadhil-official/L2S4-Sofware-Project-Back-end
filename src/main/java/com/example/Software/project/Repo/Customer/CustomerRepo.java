package com.example.Software.project.Repo.Customer;

import com.example.Software.project.Entity.Customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer,String> {
    Boolean existsByContactNumber(String contactNumber);
}
