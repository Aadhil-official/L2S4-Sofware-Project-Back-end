package com.example.Software.project.Repo.JobAllocationModule;

import com.example.project_backend.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<Customer, Long> {}

