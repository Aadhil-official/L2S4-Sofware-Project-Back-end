package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.AgreementService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementServiceRepo extends MongoRepository<AgreementService,String> {
    boolean existsById(String id);


}

