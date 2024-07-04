package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.GatePass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GatePassRepo extends MongoRepository<GatePass,String> {

    boolean existsById(String id);

}
