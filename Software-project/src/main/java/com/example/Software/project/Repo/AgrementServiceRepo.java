package com.example.Software.project.Repo;

import com.example.Software.project.Entity.AgrementService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgrementServiceRepo extends MongoRepository<AgrementService,Integer> {
}
