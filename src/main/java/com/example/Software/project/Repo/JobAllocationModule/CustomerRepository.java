


package com.example.Software.project.Repo.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long>{}




