package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitRepo extends MongoRepository<Unit,Integer> {
}
