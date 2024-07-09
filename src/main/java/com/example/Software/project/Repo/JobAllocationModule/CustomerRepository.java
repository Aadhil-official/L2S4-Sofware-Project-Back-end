


package com.example.Software.project.Repo.JobAllocationModule;

import com.example.project_backend.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long>{}




