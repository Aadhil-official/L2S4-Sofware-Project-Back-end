package com.example.Software.project.Repo.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<Customer, Long> {}

