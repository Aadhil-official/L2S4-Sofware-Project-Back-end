package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer,Integer> {

}
