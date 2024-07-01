package com.example.backendArctic.Repo;

import com.example.backendArctic.Entity.GatePass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GatePassRepo extends MongoRepository<GatePass,String> {

    boolean existsById(String id);

}
