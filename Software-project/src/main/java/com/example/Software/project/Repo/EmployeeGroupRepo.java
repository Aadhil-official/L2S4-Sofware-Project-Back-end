package com.example.Software.project.Repo;

import com.example.Software.project.Entity.EmployeeGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeGroupRepo extends MongoRepository<EmployeeGroup,Integer> {
}
