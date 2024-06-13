package com.example.dashboard.Employees;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends MongoRepository<Employees, String> {}
