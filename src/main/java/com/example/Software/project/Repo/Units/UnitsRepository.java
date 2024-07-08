package com.example.Software.project.Repo.Units;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Units.Units;


@Repository
public interface UnitsRepository extends MongoRepository<Units, String> {
    
}
