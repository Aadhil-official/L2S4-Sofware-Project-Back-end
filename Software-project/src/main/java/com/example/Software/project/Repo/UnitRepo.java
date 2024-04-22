package com.example.Software.project.Repo;

import com.example.Software.project.Entity.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitRepo extends MongoRepository<Unit,Integer> {
}
