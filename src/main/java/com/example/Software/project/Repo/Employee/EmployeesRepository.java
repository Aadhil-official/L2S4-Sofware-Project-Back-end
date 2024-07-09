package com.example.Software.project.Repo.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Employee.Employees;


@Repository
public interface EmployeesRepository extends MongoRepository<Employees, String> {}
