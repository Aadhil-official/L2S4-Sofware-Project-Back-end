package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository <Employee,Integer> {
}
