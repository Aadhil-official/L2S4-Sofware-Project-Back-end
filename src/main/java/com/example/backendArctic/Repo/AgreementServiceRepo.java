package com.example.backendArctic.Repo;


import com.example.backendArctic.Entity.AgreementService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementServiceRepo extends MongoRepository<AgreementService,String> {
    boolean existsById(String id);


}

