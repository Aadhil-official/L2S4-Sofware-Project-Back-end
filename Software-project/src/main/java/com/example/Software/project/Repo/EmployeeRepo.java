package com.example.Software.project.Repo;

import com.example.Software.project.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository <Employee,Integer> {
}
